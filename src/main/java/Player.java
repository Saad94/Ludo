import javafx.scene.paint.Color;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Player {

    private final Color color;
    private final Position startPosition;
    private final Position homeEntrancePosition;
    private final Position homeStartPosition;

    private String name;

    @Getter(AccessLevel.NONE)
    private boolean capturedSomeone;

    public boolean hasCapturedSomeone() {
        return capturedSomeone;
    }
}
