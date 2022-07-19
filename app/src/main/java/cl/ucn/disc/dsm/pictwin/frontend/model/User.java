package cl.ucn.disc.dsm.pictwin.frontend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class User {
    /**
     * The Id.
     */
    @Getter
    private Long id;

    /**
     * The Email.
     */
    @Getter
    @NonNull
    private String email;

    /**
     * The Password.
     */
    @Getter
    @Setter
    private String password;

    /**
     * The number of strikes.
     */
    @Getter
    private Integer strikes;

    /**
     * The Twins.
     */
    @Builder.Default
    @Getter
    private List<Twin> twins = new ArrayList<>();

    /**
     * Increment the strikes.
     *
     * @return the number of strikes.
     */
    public Integer incrementStrickes() {
        this.strikes++;
        return this.strikes;
    }

    /**
     * Insert a Twin in the list.
     *
     * @param twin to add.
     */
    public void add(final Twin twin){
        this.twins.add(twin);
    }

    public List<Twin> getTwins() { return this.twins; }
}
