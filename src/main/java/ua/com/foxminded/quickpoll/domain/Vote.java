package ua.com.foxminded.quickpoll.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Vote {

    @Id
    @GeneratedValue
    @Column(name="VOTE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="OPTION_ID")
    private Option option;
}
