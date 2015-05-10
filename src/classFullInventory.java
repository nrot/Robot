/**
 * Created by Nikita on 09.05.2015.
 */
public class classFullInventory {

    private int XSize,YSize;
    public classSlot slot[][] = new classSlot[3][3];

    public classFullInventory()
    {
        XSize = 3;
        YSize = 3;
        for (int i=0; i<XSize; i++)
        {
            slot[i] = new classSlot[YSize];
        }
    }
    public void FillInventory(classSlotInvCoord inv[])
    {
        for (int i=0; i<inv.length; i++)
        {
            slot[inv[i].x][inv[i].y].type = inv[i].type;
            slot[inv[i].x][inv[i].y].metadate = inv[i].metadate;
            slot[inv[i].x][inv[i].y].amount = inv[i].amount;
        }
    }
}
