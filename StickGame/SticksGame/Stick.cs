using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SticksGame
{
    public class Stick
    {
        public Boolean Running { get; private set; }
        private int[] Rows; //how many stick you have in each row
        private int Step;
        private bool skip;
        private int lastPlayer;
        private int playerNumber;

        public Stick()
        {
            playerNumber = 0;
            lastPlayer = 0;
            Step = 0;
            skip = false;
            int add = 1;
            Rows = new int[5];

            // Init rows
            for (int i = 0; i < 5; i++)
            {
                Rows[i] = add;
                add += 2;  //add two sticks on each additional row
            }
        }

        private void Help() //type "help" for the game's rules
        {
            Console.WriteLine("Welcome to stick Game");
            Console.WriteLine("It's a 2 players game");
            Console.WriteLine("Each turn you have to take a amount of sticks on a row");
            Console.WriteLine("The player who takes the last stick lose the game");
            Console.WriteLine("For taking sticks from a row you have to write for example 3,2 it means from the row 4 take 2 sticks");
            Console.WriteLine("Let's play !\r\n\r\n");
        }

        private void Rules(String answer) //Check whether the entered command is correct and also remove sticks if the command is correct
        {
            String[] res = answer.Split(new char[] { ',' });
            int row;
            int nstick;

            if (res.Length != 2 || !int.TryParse(res[0], out row) || !int.TryParse(res[1], out nstick) || row > 4 || row < 0 || nstick > Rows[row] || nstick < 1)
            {
                skip = true;
                if (Step == 1)
                    Step = 0;
                else
                    Step = 2;
                Console.WriteLine("You entered an invalid command, please try again");
            }
            else
            {
                skip = true;
                Rows[row] -= nstick; //if the command is correct, decrease the given number of sticks on the row
                MiscCommands("display", true); 
                if (Step == 1) //if it's the player no.1 turn
                {
                    playerNumber = 1;
                    lastPlayer = 2;
                    Step++;
                }
                else //if it's the player no.2 turn
                {
                    lastPlayer = 1;
                    playerNumber = 2;
                    Step = 0;
                }
            }
        }

        private void Steps(String answer) // turn-based playing between players
        {
            Console.Write("\r\n\r\n");
            switch (Step)
            {
                case 0:
                    Console.Write("Player 1 your turn : ");
                    Step++;
                    break;
                case 1:
                    Rules(answer);
                    break;
                case 2:
                    Console.Write("Player 2 your turn : ");
                    Step++;
                    break;
                case 3:
                    Rules(answer);
                    break;
            };
        }

        private void MiscCommands(String answer, bool ignoreStep = false)
        {
            if ("display".Equals(answer, StringComparison.InvariantCultureIgnoreCase)) //display sticks when the player type "display"
            {
                int rn = 0;
                foreach (int cur in Rows)
                {
                    Console.Write(rn + " ");
                    for (int i = 0; i < cur; i++)
                    {
                        Console.Write("|");
                    }
                    Console.Write("\r\n");
                    rn++;
                }
                if (!ignoreStep)
                {
                    if (Step == 1)
                        Step = 0;
                    else
                        Step = 2;
                }
            }
            else if ("help".Equals(answer, StringComparison.InvariantCultureIgnoreCase)) //display help when the player type "help"
            {
                Console.Write("\r\n\r\n");
                Help();
                if (Step == 1)
                    Step = 0;
                else
                    Step = 2;
            }
        }

        private void CheckEndGame() //if the last stick belongs to which player, he will lose
        {
            int res = Rows.Sum();
            if (res == 1) //if there is just one stick remainning, the next player will lose
            {
                Console.WriteLine("Player " + lastPlayer + " you have lost, you took the last stick !");
                Running = false;
            }
            else if (res == 0)//if there is no stick remaining, the current player will lose
            {
                Console.WriteLine("Player " + playerNumber + " you have lost, you took the last stick !");
                Running = false;
            }
        }

        public void Run()
        {
            String answer = null;

            Running = true;
            Help();
            MiscCommands("display", true);
            while (Running) // the main loop for the game which called the above methods for the rules
            {
                Steps(answer);
                if (!skip)
                {
                    answer = Console.ReadLine();
                    if (answer.Equals("e"))
                    {
                        //Console.Clear();  
                    }
                }
                else
                    skip = false;
                MiscCommands(answer);
                CheckEndGame();
            }
        }
    }
}
