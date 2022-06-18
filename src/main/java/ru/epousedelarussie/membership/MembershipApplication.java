package ru.epousedelarussie.membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.epousedelarussie.membership.entity.Member;
import ru.epousedelarussie.membership.repository.MemberRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;

@SpringBootApplication
public class MembershipApplication implements CommandLineRunner {

    private final MemberRepository memberRepository;

    @Autowired
    public MembershipApplication(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MembershipApplication.class, args);
    }


    @Override
    public void run(String... args)  {
        memberRepository.saveAll(
                Arrays.asList(
                        new Member("Gloire",
                                "Mfouna",
                                "8907867658",
                                "masc",
                                Timestamp.valueOf(
                                        LocalDateTime.of(LocalDate.of(1994, Month.SEPTEMBER, 14),
                                                LocalTime.now()))
                        ),
                        new Member("Godson",
                                "Essonga",
                                "3555656666",
                                "masc",
                                Timestamp.valueOf(
                                        LocalDateTime.of(LocalDate.of(1992, Month.JUNE, 13),
                                                LocalTime.now()))
                        ),
                        new Member("Isodore",
                                "Bakanja",
                                "89696766575",
                                "masc",
                                Timestamp.valueOf(
                                        LocalDateTime.of(LocalDate.of(1992, Month.DECEMBER, 23),
                                                LocalTime.now()))
                        ),
                        new Member("Brunel",
                                "Anga",
                                "6879786907987",
                                "masc",
                                Timestamp.valueOf(
                                        LocalDateTime.of(LocalDate.of(1991, Month.JUNE, 12),
                                                LocalTime.now()))
                        ),
                        new Member("Isidore",
                                "Anga",
                                "6879786907987",
                                "masc",
                                Timestamp.valueOf(
                                        LocalDateTime.of(LocalDate.of(1993, Month.JANUARY, 1),
                                                LocalTime.now()))
                        )
                )
        );
    }
}
