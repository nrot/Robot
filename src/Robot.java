/**
 * Created by Nikita on 09.05.2015.
 */
public class Robot
{
    public String Name;
    public int NoRobot;
    private classFullInventory Inventory = new classFullInventory();
    public Robot(String NameRobot,int NoRobot)
    {
        Name = NameRobot;
        this.NoRobot = NoRobot;
    }
    public boolean Move(classField Field ,String Direction)
    {
        if (Field.CanMove(this.NoRobot, Direction))
        {
            Field.MoveRobot(this.NoRobot, Direction);
            return true;
        }
        else
        {
        return false;
        }
    }
    public int Move(classField Field, String Direction, int MoveAmount)
    {
        for (int i=1; i<=MoveAmount; i++)
        {
            boolean reslutMove = this.Move(Field, Direction);
            if (!reslutMove)
            {
                return i;
            }
        }
        return -1;
    }
    public void Turn(classField Field, String Direction)
    {
        Field.EditDerection(this.NoRobot, Direction);
    }
    private boolean PlaceToInvetory(classSlotInvCoord item)
    {
        for (int x=0; x<Inventory.slot.length; x++)
        {
            for (int y=0; y<Inventory.slot[0].length; y++)
            {
                if (Inventory.slot[x][y].type==item.type && Inventory.slot[x][y].metadate==item.metadate)
                {
                    int nohave = 64 - Inventory.slot[x][y].amount;
                    if (item.amount <= nohave)
                    {
                        Inventory.slot[x][y].amount += item.amount;
                        return true;
                    } else
                    {
                        Inventory.slot[x][y].amount = 64;
                        item.amount -= nohave;
                    }
                }
            }
        }
        return false;
    }
    private void ReplaceInInventory(int startx, int starty, int stopx, int stopy)
    {
        int temptype = Inventory.slot[stopx][stopy].type;
        int tempmetadate = Inventory.slot[stopx][stopy].metadate;
        Inventory.slot[stopx][stopy].type = Inventory.slot[startx][starty].type;
        Inventory.slot[stopx][stopy].metadate = Inventory.slot[startx][starty].metadate;
        Inventory.slot[startx][starty].type = temptype;
        Inventory.slot[startx][starty].metadate = tempmetadate;
    }
}
