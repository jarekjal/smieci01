package jarekjal.nauka;

import java.io.Serializable;

public interface OwnerStrategy extends Serializable {
    boolean isForeign();
    int fee();
}
