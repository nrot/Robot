import java.lang.reflect.Field;

/**
 * Created by Nikita on 09.05.2015.
 */
public class Main {
    public static void main(String[] args)
    {
        boolean run = true;
        while (run)
        {
            classField Field = new classField();
            Field.CreateRobot("First", 10, 10, "x+");
            classSlotInvCoord Item1 = new classSlotInvCoord(11, 11, 2, 0, 1);
            Field.PlaceItem(Item1);
            Field.DrawPlane();
        }
    }
}
