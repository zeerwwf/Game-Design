using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SticksGame
{
    class Program
    {
        private static String keyExit;
        static void Main(string[] args)
        {
            do{
            new Stick().Run();
            Console.WriteLine("Press \"e\" keys to exit, or press any key to restart");
            if (Console.ReadKey().Key == ConsoleKey.E)
                break;
            }while(true);
        }
    }
}
