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
            string input = "aa bb cc dd ee\naa bb cc dd aa\naa bb cc dd aaa";

            string[] phrases = input.Split(new char[] { '\n' }, StringSplitOptions.RemoveEmptyEntries);
            int sum = 0;

            foreach (string phrase in phrases)
            {
                HashSet<string> hashSet = new HashSet<string>();
                bool valid = true;
                string[] words = phrase.Trim().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                foreach (string word in words)
                {
                    if(!hashSet.Add(word))
                    {
                        valid = false;
                        break;
                    }
                }

                if (valid)
                {
                    sum++;
                }

            }

            Debug.WriteLine("sum: " + sum);

        }
    }
}
