public class classSlotInvCoord extends classSlot{
    public int x,y;
    public classSlotInvCoord(int x, int y, int type, int metadate, int amount)
    {
        super(type, metadate,amount);
        this.x = x;
        this.y = y;
    }
}
