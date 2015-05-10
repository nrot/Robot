/**
 * Created by Nikita on 09.05.2015.
 */

public class classField
{
    //Init Coord face
    protected final int YMaxCoord = 20;
    protected final int XMaxCoord = 20;
    private PLaneSlot[][] plane = new PLaneSlot[XMaxCoord ][YMaxCoord ];
    private void InitCoord()
    {
        for (int x = 0; x< plane.length; x++)
        {
            plane[x] = new PLaneSlot[YMaxCoord];
            for (int y =0; y<plane[x].length; y++)
            {
                plane[x][y] = new PLaneSlot(0, 0, true);
            }
        }
    }

    //Init list robots

    private class classRobotsList
    {
        public Robot RobotEx;
        public int XExemplar, YExemplar;
        public String DirectionExemplar;
    }
    private classRobotsList[]  RobotsList = new classRobotsList[YMaxCoord*XMaxCoord];
    private int amountRobot = 0;

    //Init Quest move

    public boolean CanMove(int NoRobot, String direction)
    {
        boolean ret = false;
        switch (direction)
        {
            case "x+" : if (!plane[RobotsList[NoRobot].XExemplar++][RobotsList[NoRobot].YExemplar].empty)
                ret = false;
            else ret = true;
            break;
            case "x-" : if (!plane[RobotsList[NoRobot].XExemplar--][RobotsList[NoRobot].YExemplar].empty)
                ret = false;
            else ret = true;
            break;
            case "y+" : if (!plane[RobotsList[NoRobot].XExemplar][RobotsList[NoRobot].YExemplar++].empty)
                ret = false;
            else ret = true;
            break;
            case "y-" : if (!plane[RobotsList[NoRobot].XExemplar][RobotsList[NoRobot].YExemplar--].empty)
                ret = false;
            else ret = true;
            break;
        }
        return ret;
    }

    public void MoveRobot(int NoRobot, String direction)
    {
        switch (direction)
        {
            case "x+" : RobotsList[NoRobot].XExemplar++; break;
            case "x-" : RobotsList[NoRobot].XExemplar--; break;
            case "y+" : RobotsList[NoRobot].YExemplar++; break;
            case "y-" : RobotsList[NoRobot].YExemplar--; break;
        }
    }

    public void EditDerection(int NoRobot, String direction)
    {
        RobotsList[NoRobot].DirectionExemplar = direction;
    }
    public classField()
    {
        InitCoord();
    }
    public boolean CreateRobot(String NameRobot, int x, int y, String derection)
    {
        if (plane[x][y].empty)
        {
            RobotsList[amountRobot] = new classRobotsList();
            RobotsList[amountRobot].RobotEx = new Robot(NameRobot, amountRobot);
            RobotsList[amountRobot].DirectionExemplar = derection;
            RobotsList[amountRobot].XExemplar = x;
            RobotsList[amountRobot].YExemplar = y;
            plane[x][y].type = 1;
            plane[x][y].metadate = amountRobot;
            plane[x][y].amount = 1;
            plane[x][y].empty = false;
            amountRobot ++;
            return true;
        } else  return false;
    }

    public boolean PlaceItem(classSlotInvCoord item)
    {
        if (plane[item.x][item.y].empty)
        {
            plane[item.x][item.y].type = item.type;
            plane[item.x][item.y].metadate = item.metadate;
            plane[item.x][item.y].empty = false;
            return true;
        } else return false;
    }
    public void DeleteItem(int x, int y)
    {
        plane[x][y].empty = true;
        plane[x][y].type = 0;
        plane[x][y].metadate = 0;
        plane[x][y].amount = 0;
    }
    public classSlot TakeItem(int x, int y)
    {
        classSlot Ret = new classSlot(plane[x][y].type,plane[x][y].metadate, 1 );
        this.DeleteItem(x,y);
        return Ret;
    }
    public int XRobotCoord(int NoRobot)
    {
        return RobotsList[NoRobot].XExemplar;
    }
    public int YRobotCoord(int NoRobot)
    {
        return RobotsList[NoRobot].YExemplar;
    }
    public void DrawPlane()
    {
        for (int x=0; x<plane.length; x++)
        {
            for (int y = 0; y<plane[0].length; y++)
            {
                switch (plane[x][y].type)
                {
                    case 0 : System.out.print("O"); break;
                    case 1 : System.out.print("R"); break;
                    default: System.out.print("I");
                }
            }
            System.out.print("\n");
        }
    }
}
