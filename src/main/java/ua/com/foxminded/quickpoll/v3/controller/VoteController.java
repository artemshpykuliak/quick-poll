package ua.com.foxminded.quickpoll.v3.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.com.foxminded.quickpoll.dao.VoteRepository;
import ua.com.foxminded.quickpoll.domain.Vote;

import javax.inject.Inject;

@RestController("voteControllerV3")
@RequestMapping("/v3/")
@Api(value = "votes", description = "Vote API")
public class VoteController {

    @Inject
    private VoteRepository voteRepository;

    @RequestMapping(value="/polls/{pollId}/votes", method= RequestMethod.POST)
    @ApiOperation(value = "Casts a new vote for a given poll",
            notes = "The newly created vote Id will be sent in the location response header",
            response = Void.class)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Vote Created Successfully",
                    response = Void.class)})
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        vote = voteRepository.save(vote);
        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(vote.getId()).toUri());
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/polls/{pollId}/votes", method= RequestMethod.GET)
    @ApiOperation(value = "Retrieve all votes", response = Vote.class, responseContainer = "List")
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        return voteRepository.findByPoll(pollId);
    }
}
