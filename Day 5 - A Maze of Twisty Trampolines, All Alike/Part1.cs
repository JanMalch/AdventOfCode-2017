using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Part1
    {
        static void Main(string[] args)
        {
            string input = "...";

            List<int> numbers = input.Trim().Split(new char[] { '\n' }, StringSplitOptions.RemoveEmptyEntries).Select(str => int.Parse(str)).ToList();
			
			int index = 0;
			int steps = 0;
			
			while(index >= 0 && index < numbers.Count) {
				index += numbers[index]++;
				steps++;
			}

            Debug.WriteLine("steps: " + steps);

        }
    }
}
