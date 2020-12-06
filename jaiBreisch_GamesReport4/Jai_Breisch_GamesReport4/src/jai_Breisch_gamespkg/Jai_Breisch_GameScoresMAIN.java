/*Jai Breisch Week 3 Games Score and Report     Ver 405-12620  
  
 																		   *
 * This project will demonstrate reading and writing to files.             *
 * -fileReader will read the csv document "GameScores" and generate 	   *
 * an array showing scores for each game and a total for each player.      *
 * Then, using fileWriter, I will add a new player "Jai" and a set of new  *
 * scores and then calculate who is the winner based on those scores.      * 
 */
package jai_Breisch_gamespkg;

//This is where I import the Java Directories that I will use to do calculations
//To save time I will import them all using java.io.* and java.util.*  to pull in all directories/utilities

import java.io.*; 

public class Jai_Breisch_GameScoresMAIN {

	public static void main(String[] args) throws IOException
			
			{
		File fileName = new File(System.getProperty("user.dir") + "\\GameScores.csv");

				gameReport(fileName);
		//add in a new Gamer, in this case it is me "Jai" 
				addGamer (fileName, "Jai", 180, 145, 199, 189, 200, 149, 179, 199, 195, 187);
				
				gameReport(fileName);
				
			}
		//put all gamers into the system by parsing out the csv file into segments
			private static void addGamer(File fileName, String gamerName , 
									int a, int b, int c, 
									int d, int e, int f, 
									int g, int h, int i, 
									int j) throws IOException
			
			{
				FileWriter csvWriter = new FileWriter(fileName, true); 
			
				csvWriter.write(gamerName + "," + a + "," + b + 
										"," + c + "," + d + 
										"," + e + "," + f + 
										"," + g + "," + h + 
										"," + i + "," + j + "\r\n");			
			
				System.out.printf("%n Gamer %s record added.%n%n", gamerName);
				csvWriter.close();
			}
			
	// Create a new class with a nested "do loop," inside of a "do-while" loop 
		
				private static void gameReport(File fileName) throws IOException
			{
				if (fileName.exists())
				{
					BufferedReader br = null;
					String line = "";
					String cvsSplitBy = ",";
					int recordCount = 0;
					int participants = 0;
					int winner = 0;
					String winnerName = "";
					
					
					br = new BufferedReader(new FileReader(fileName));
	//Add print statements so that it will print the scores to the console
					horizontalLine(93);
					System.out.println("Game Report");
					horizontalLine(93);
					System.out.println("Gamer\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tTotal");
					horizontalLine(93);
					
					
					
					while ((line = br.readLine())	!= null)
					{
	//Create a table of values based on the CSV file imported, arranged to figure out who won
						String[] participant = line.split(cvsSplitBy); 
						
						participants = Integer.parseInt(participant[1]) + Integer.parseInt(participant[2])
									+ Integer.parseInt(participant[3]) + Integer.parseInt(participant[4])
									+ Integer.parseInt(participant[5]) + Integer.parseInt(participant[6])
									+ Integer.parseInt(participant[7]) + Integer.parseInt(participant[8])
									+ Integer.parseInt(participant[9]) + Integer.parseInt(participant[10].substring(0, 2));
						
						System.out.print(
								  participant[0] + "\t" + participant[1] + "\t"
								+ participant[2] + "\t" + participant[3] + "\t"
								+ participant[4] + "\t" + participant[5] + "\t"
								+ participant[6] + "\t" + participant[7] + "\t"
								+ participant[8] + "\t" + participant[9] + "\t"
								+ participant[10]);
						
						System.out.println("\t" + participants);
						
						if (participants > winner)
						{
							winner = participants;
							winnerName = participant[0];
						}
						recordCount++;
						participants = 0;
						
					}
					
		//Now we can print the winner based on the computations done by our utilities etc.
					horizontalLine(93);
					System.out.printf("# of Gamers:\t%d%n", recordCount);
					System.out.printf("The Winner IS:\t%s%n", winnerName);
					horizontalLine(93);
					br.close();
					fileName = null;
					
						}	
						
					}

			private static void horizontalLine(int dashes) 
				
			{
				for (int i = 1; i <= dashes; i++)
				{
					System.out.print(".");
				}
				System.out.println();

			}

 }

//IS THERE AN EASIER WAY TO USE A LOOP TO SAVE ALL THE WORK DONE IN LINE 89-101???
