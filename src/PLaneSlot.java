/**
 * Created by Nikita on 10.05.2015.
 */
public class PLaneSlot extends classSlot{
    boolean empty;
    public PLaneSlot(int type, int metadate, boolean CanMove)
    {
        super(type, metadate, 1);
        if (CanMove)
        {
            this.amount = 0;
        }
        this.empty = CanMove;
    }
}
