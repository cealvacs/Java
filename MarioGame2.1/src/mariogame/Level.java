package MarioGame;

import java.util.Random;
import javax.swing.JOptionPane;
import mariogame.Player;


public class Level {
    public static int gridNum = 7;
    private int grid[][] = {{1,1,0,1,0,1,0,1},{1,1,1,1,1,1,1,1},{1,0,1,1,1,0,1,0},{1,1,1,0,1,1,1,1},{1,0,1,1,1,0,1,1},{1,1,1,0,1,1,1,0},{1,0,1,1,1,0,1,1},{1,1,0,1,1,1,0,1}};
  //Grid that represents game board and hardcoded walls(0) and player possible moves(1)
    public Level() {
       
    }
    //Default Java constructor for level

    public int getGrid(int row, int col) {
        return grid[row][col];
    }
    //Call fourth game board
    
    public void setGrid (int row, int col, int val)
    {
        grid[row][col] = val;
    }
    //set and alter game board
    public void compPlayer (Player comp)
    {  //Computer random moves and keys 
        boolean flag = false;
        int temp = 0;
        
        
        do
        {
            int key = randNum();
            System.out.println(key);
            if (key == 0)//Up
            {
                temp = comp.getRowPos()-1; //moves row by 1 upwards 
                if (temp < 0)
                {       
                    key = 0;
                    temp = 0;

                }
                else 
                {
                    
                    if (this.getGrid(temp, comp.getColPos()) == 0 || this.getGrid(temp, comp.getColPos()) == 2 )
                        {
                            
                        }
                    else
                        {                           
                            comp.setRowPos(temp);
                            comp.setColPos(comp.getColPos());
                            JOptionPane.showMessageDialog(null, "o: AHAH! I'm getting there...I think..");
                        }
                    flag = true;
                }
            }
            if (key == 1)//Down
            {
                temp = comp.getRowPos()+1; //moves down in row once 
                if (temp > gridNum)
                {                   
                    key = 0;
                    temp = 0;     
                }
                else
                {
                    
                    if (this.getGrid(temp, comp.getColPos()) == 0 || this.getGrid(temp, comp.getColPos()) == 2) //2 means wall
                        {
                            
                        }
                    else
                        {           
                            comp.setRowPos(temp);
                            comp.setColPos(comp.getColPos());
                        }
                    flag = true;
                }
            }
            if (key == 2)//Left //moves left in column once 
            {
                temp = comp.getColPos()-1;
                if (temp < 0)
                {
                    
                    key = 0;
                    temp = 0;
                    JOptionPane.showMessageDialog(null, "o: DOH! >_<\ni: what's the problem? GET IT TOGETHER MAN! ");
                    
                     
                }
                else
                {
                                 
                    if (this.getGrid(comp.getRowPos(), temp) == 0 || this.getGrid(comp.getRowPos(), temp) == 2)
                        {
                            
                            
                            JOptionPane.showMessageDialog(null, "o: NOOO..You FOOL! I MUST EMERGE VICTORIOUS!"); // never displays wall location
                        }
                    else
                        {
                            
                            comp.setRowPos(comp.getRowPos());
                            comp.setColPos(temp);  //updates position 
                        }
                    flag = true;
                }
            }
            if (key == 3)//Right   //moves right on column once 
            {
                temp = comp.getColPos()+1;
                if (temp > gridNum)
                {
                    
                    key = 0;
                    temp = 0;
                    
                    
                    
                }
                else
                {
                    
                    if (this.getGrid(comp.getRowPos(), temp) == 0 || this.getGrid(comp.getRowPos(), temp) == 2)
                        {
                            
                        }
                    else
                        {
                            
                            comp.setRowPos(comp.getRowPos());
                            comp.setColPos(temp);
                        }
                    flag = true;
                }
            }
        
        }while (!flag);
        
    }
    
    public void movePlayer (Player user)
    {
        int temp = 0;
        int key= 5;
        do
        {
           
            boolean fail = false;
            
            do
            {
                String test = JOptionPane.showInputDialog("Enter your command\n0 to EXIT");
                try
                    {
                       key = Integer.parseInt(test);

                       fail = true;
                    }
                catch ( Exception e )
                    {
                       JOptionPane.showMessageDialog(null,"Enter only integers\n8 - UP\n2 - DOWN\n4 - LEFT\n6 - RIGHT");
                       System.out.println(e.toString());
                       key=5;

                    }
                finally
                    {
                        if (key ==0)
                            System.exit(0);
                    }

            }while (!fail); 
                      
            if (key == 8)
            {
                temp = user.getRowPos()-1; //moves up row by one 
                if (temp < 0)
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Move: You gotten out of grid\nTry Again");
                    key = 0;
                    temp = 0;
                    continue;
                }
                else 
                {
                    validation(temp, user.getColPos(), user);      
                }
            }
            if (key == 2) // moves down row by one 
            {
                temp = user.getRowPos()+1;
                if (temp > gridNum)
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Move: You gotten out of grid\nTry Again");
                    key = 0;
                    temp = 0;
                    continue;
                }
                else
                {
                    validation(temp, user.getColPos(), user); 
                   
                }
            }
            if (key == 4)
            {
                temp = user.getColPos()-1; //moves left on column by one
                if (temp < 0)
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Move: You gotten out of grid\nTry Again");
                    key = 0;
                    temp = 0;
                    continue;
                }
                else
                {
                    validation(user.getRowPos(), temp, user);               
                }
            }
            if (key == 6) //moves right in column by one
            {
                temp = user.getColPos()+1;
                if (temp > gridNum)
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Move: You gotten out of grid\nTry Again");
                    key = 0;
                    temp = 0;
                    continue;
                }
                else
                {
                    validation(user.getRowPos(), temp, user);
                    
                }
            }
                 

        
        } while (key != 8 && key != 2 && key != 4 && key != 6);
        
        
        
    }
    
    public void printGrid (int p1Row, int p1Col, int compRow, int compCol)
    {
        for (int i=0; i<grid.length; i++) //prints game grid and mangages the discreation of the hidden walls and ghosts
        {   
            for (int j=0; j<grid[0].length; j++)
            {
                if (i == p1Row && j == p1Col && i == compRow && j == compCol)
                        System.out.print("x"+" ");
                else
                    if (i == p1Row && j == p1Col)
                        System.out.print("i"+" ");
                else 
                    if (i == compRow && j == compCol)
                        System.out.print("o"+" ");           
                else 
                    if (this.getGrid(i, j) == 2)
                        System.out.print("*"+" ");
                    
                else System.out.print("_"+" ");
            }
            
            System.out.println();            
        }
        
    }
    
    public void validation (int tRow, int tCol, Player user)
    {
        
            if (this.getGrid(tRow, tCol) == 0 || this.getGrid(tRow, tCol) == 2)
            {
                JOptionPane.showMessageDialog(null, "You encountered a wall!!!\nLost your turn...be more careful");
                setGrid(tRow, tCol, 2);
                
                //Wall hit for player mode 
            }
            else   //The random appearance of ghosts and such
            {
                JOptionPane.showMessageDialog(null, "Nicely chosen...Let's see what awaits!!!");
                user.setRowPos(tRow);
                user.setColPos(tCol);
                int num = randNum();
                
                if (num == 0)
                    JOptionPane.showMessageDialog(null, "The path is free !!!");             
                if (num == 1)
                {                    
                    user.setLife(user.getLife()-5);     
                    JOptionPane.showMessageDialog(null, "You found a ghost!!! He took 5 life points\nYour current life is: " + user.getLife());
                }
                if (num == 2)
                {
                    user.setLife(user.getLife()-10);
                    JOptionPane.showMessageDialog(null, "You found an EVIL ghost!!! He took 10 life points\nYour current life is: " + user.getLife());
                    JOptionPane.showMessageDialog(null, "i: GAHHHHHH! "); //comic relief commentary by player and computer 
                }
                if (num == 3)
                {
                    user.setLife(user.getLife()+5);
                    JOptionPane.showMessageDialog(null, "You found Casper!!! He gave you 5 life points\nYour current life is: " + user.getLife());
                    JOptionPane.showMessageDialog(null, "i: 5? You greedy bastard! give me more life!");
                }
            }
        
    }
    
    public int randNum ()
    {   //Display ghosts randonmly by this method 
        Random rand = new Random();       
        int number = rand.nextInt(4);

        return number; 
    }
    public void gamePlay (Player user, Player comp)
    {
        boolean flag = false;
        
        do
        {
            
            System.out.println("p1 Row: " + user.getRowPos()+ " Col: " + user.getColPos());
            System.out.println("comp Row: " + comp.getRowPos()+ " Col: " + comp.getColPos());
            
            printGrid(user.getRowPos(),user.getColPos(),comp.getRowPos(),comp.getColPos());
            movePlayer(user);
            if (user.getLife() <= 0 )  //Life points,death,Lose,& Win implementations 
            {
                JOptionPane.showMessageDialog(null, "You ran out of life!!!\nGAME OVER");
                JOptionPane.showMessageDialog(null, "i: I..have..perished2 x.x");
                flag = true;
                continue;
            }
            
            else 
                if (user.getRowPos() == gridNum && user.getColPos()== gridNum) //Location of the "end"
                {
                    JOptionPane.showMessageDialog(null, user.getName() +" you Won !!!!\nCongratulations!!!");
                    JOptionPane.showMessageDialog(null, "i: VICTORY! ^_^\no: shut up T_T ");
                   
                    flag = true;
                }
            
            compPlayer(comp);
            if (comp.getRowPos() == gridNum && comp.getColPos()== gridNum)
            {
                JOptionPane.showMessageDialog(null, "GAME OVER \nComputer won the game");
                JOptionPane.showMessageDialog(null, "o: YES HAHAAA LOSER! =P\ni: how the hell?!");
                
                flag = true;
            }

           
            for (int i = 0; i <4; i++)
            {
                System.out.println("\n");
            }
            
        }while (!flag);
        
        
        
    }
    
    
}
