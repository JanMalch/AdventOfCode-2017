using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Part2
    {
        static void Main(string[] args)
        {
            string input = "abcde fghij\nabcde xyz ecdab\na ab abc abd abf abj\niiii oiii ooii oooi oooo\noiii ioii iioi iiio";

            string[] phrases = input.Split(new char[] { '\n' }, StringSplitOptions.RemoveEmptyEntries);
            int sum = 0;

            foreach (string phrase in phrases)
            {
                HashSet<string> hashSet = new HashSet<string>();
                bool valid = true;
                string[] words = phrase.Trim().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

                foreach (string word in words)
                {
                    string wordOrdered = String.Concat(word.OrderBy(c => c));

                    foreach (string setWord in hashSet)
                    {
                        string setWordOrdered = String.Concat(setWord.OrderBy(c => c));

                        if (wordOrdered.Equals(setWordOrdered))
                        {
                            valid = false;
                            break;
                        }
                    }

                    if (!hashSet.Add(word))
                    {
                        valid = false;
                    }

                    if (!valid)
                    {
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
