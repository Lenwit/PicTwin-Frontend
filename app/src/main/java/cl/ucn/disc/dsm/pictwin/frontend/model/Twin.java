package cl.ucn.disc.dsm.pictwin.frontend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Twin of Pic.
 *
 * @author Mack Díaz Vilches.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Twin {
    /**
     * The Id.
     */
    @Getter
    private Long id;

    /**
     * The dislike.
     */
    @Getter
    @Setter
    @Builder.Default
    private Boolean dislike = Boolean.FALSE;

    /**
     * The Pic.
     */
    @Getter
    private Pic my;

    /**
     * The Pic.
     */
    @Getter
    private Pic yours;

    /**
     * The Owner
     */
    @Getter
    private User owner;

    public Pic getMy() {
        return this.my;
    }

    public Pic getYours() {
        return this.yours;
    }
}
