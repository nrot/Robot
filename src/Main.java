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
            Field.PlaceItem(new classSlotInvCoord(9, 9, 3, 10, 1));
            Field.DrawPlane();
            long timeSleep =(long) (double) Math.pow(10, 3)*60;
            try {
                Thread.sleep(timeSleep);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
