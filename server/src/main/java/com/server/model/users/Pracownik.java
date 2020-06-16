package com.server.model.users;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private float pensja;
    private float premia;

    @OneToOne
    @JoinColumn(name="user_id")
    @NotNull
    private User user;

    @OneToOne
    @JoinColumn(name="kurier_id")
    private Kurier kurier;

    @OneToOne
    @JoinColumn(name="pracownik_sortowni_id")
    private PracownikSortowni pracownikSortowni;
}
