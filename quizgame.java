import arc.*;

public class quizgame{
	public static void main(String[] args){
		
		// Variables
		
		// Console
		Console con = new Console("Quiz Game", 1280, 720);
		// Navigation
		double dblPage = 1.1;
		char chrMenu = 'i';
		// Name
		String strName;
		// Quiz Selection
		int intCount;
		String strChoice;
		// Gameplay
		// Text
		
		
		while(dblPage > 0){
		
			// 1.1 Main Menu
			while(dblPage == 1.1){
				chrMenu = 'i';
				con.println("Main menu page");
				menuDisplay(con);
				dblPage = menuSelect(con);
				con.clear();
			}
			
			// 2.1 Play Quiz 
			while(dblPage == 2.1){
				con.clear();
				con.println("play page");
				// Enter Name
				strName = name(con);
				con.clear();
				// Quiz Selection
				System.out.println("Display quiz choices");
				strChoice = quizSelect(con);
				// Gameplay
				game(strName, strChoice, con);
				con.clear();
				// method(strChoice
				
				// Return to Main Menu
				con.print("Press 'm' to return to the menu");
				while(chrMenu != 'm'){
					chrMenu = con.getChar();
					if(chrMenu == 'm'){
						dblPage = 1.1;
					}
				}
			}
			 
			// 2.2 Enter Name
			//while(dblPage == 2.2){
			//}
			
			// 2.3 Select Quiz
			while(dblPage == 2.3){
			}
			
			// 2.4 Play Quiz
			while(dblPage == 2.4){
			}
			
			// 2.5 Stats and Option to Return to Menu
			while(dblPage == 2.5){
			}
			
			// 3.1 High Scores
			while(dblPage == 3.1){
				loadScores(con);
				// Return to Main Menu
				con.print("Press 'm' to return to the menu");
				while(chrMenu != 'm'){
					chrMenu = con.getChar();
					if(chrMenu == 'm'){
						dblPage = 1.1;
					}
				}
			}
			
			// 4.1 Create a Quiz
			while(dblPage == 4.1){
				create(con);
				// Return to Main Menu
				con.print("Press 'm' to return to the menu");
				while(chrMenu != 'm'){
					chrMenu = con.getChar();
					if(chrMenu == 'm'){
						dblPage = 1.1;
					}
				}
			}
			
			// 5.1 Help
			while(dblPage == 5.1){
				help(con);
				// Return to Main Menu
				con.print("Press 'm' to return to the menu");
				while(chrMenu != 'm'){
					chrMenu = con.getChar();
					if(chrMenu == 'm'){
						dblPage = 1.1;
					}
				}
			}
			
			// 6.1 Quit
			while(dblPage == 6.1){
				con.closeConsole();
				// Return to Main Menu
				con.print("Press 'm' to return to the menu");
				while(chrMenu != 'm'){
					chrMenu = con.getChar();
					if(chrMenu == 'm'){
						dblPage = 1.1;
					}
				}
			}
		
		}
		
		
	}
	// METHODS
	
	// Menu Graphics
	public static void menuDisplay(Console con){
		con.clear();
		con.println("Select an option:\n(p)lay\nHigh (s)cores\n(c)reate quiz\n(h)elp\n(q)uit");
	}
	
	// Select Menu Option
	public static double menuSelect(Console con){
		char chrMenu = con.getChar();
		double dblChoice = 0;
		if(chrMenu == 'p'){
			dblChoice = 2.1;
		}else if(chrMenu == 's'){
			dblChoice = 3.1;
		}else if(chrMenu == 'c'){
			dblChoice = 4.1;
		}else if(chrMenu == 'h'){
			dblChoice = 5.1;
		}else if(chrMenu == 'q'){
			dblChoice = 6.1;
		}
		con.clear();
		return dblChoice;
	}
	
	// Play - Name Input
	public static String name(Console con){
		con.clear();
		con.print("Enter your name: ");
		String strName = con.readLine();
		return strName;
	}
	
	// Play - Select a Quiz
	public static String quizSelect(Console con){
		// Variables
		String strCount;
		int intCount;
		int intQCount = 0;
		char chrChoice = ' ';
		// Count Quizzes
		TextInputFile txtMaster = new TextInputFile("quizzes.txt");
		while(txtMaster.eof() == false){
			strCount = txtMaster.readLine();
			System.out.println("intQCount: "+intQCount);
			intQCount = intQCount + 1;
		}
		txtMaster.close();
		System.out.println("Final intQCount: "+intQCount);
		// Load Names into Array and Display to Screen
		String strSelect[] = new String[intQCount];
		txtMaster = new TextInputFile("quizzes.txt");
		con.println("Quiz Options:");
		for(intCount = 0; intCount < intQCount; intCount++){
			strSelect[intCount] = txtMaster.readLine();
			System.out.println("strSelect["+intCount+"] = "+strSelect[intCount]);
			con.println(intCount+": "+strSelect[intCount]);
		}
		txtMaster.close();
		// Select Quiz
		int intChoice = con.readInt();
		System.out.println("intChoice = "+intChoice); 
		System.out.println("strSelect[intChoice] = "+strSelect[intChoice]);
		return strSelect[intChoice];
	}
	
	// Play - Gameplay
	public static void game(String strName, String strChoice, Console con){
		con.clear();
		// Variables
		double dblPercent = 0;
		int intQuestions = 0;
		double dblCorrect = 0;
		char chrCont = 'a';
		String strQ; // Questions
		String strA[] = new String[4]; // Answers
		String strC; // Correct answer
		int intCount;
		int intColumn;
		// Selected Quiz
		String strQuizName = strChoice + ".txt";
		System.out.println("Selected Quiz File: "+strQuizName);
		// Count Questions
		TextInputFile txtQuiz = new TextInputFile(strQuizName);
		while(txtQuiz.eof() == false){
			strQ = txtQuiz.readLine();
			for(intCount = 0; intCount < 4; intCount++){
				strA[intCount] = txtQuiz.readLine();
			}
			strC = txtQuiz.readLine();
			intQuestions = intQuestions + 1;
		}
		txtQuiz.close();
		System.out.println("Number of Questions: "+intQuestions);
		// Load Questions into Array
		txtQuiz = new TextInputFile(strQuizName);
		String strQuiz[][] = new String[intQuestions][6];
		for(intCount = 0; intCount < intQuestions; intCount++){
			for(intColumn = 0; intColumn < 6; intColumn++){
				strQuiz[intCount][intColumn] = txtQuiz.readLine();
				System.out.println("strQuiz["+intCount+"]["+intColumn+"] = "+(strQuiz[intCount][intColumn]));
			}
		} 
		txtQuiz.close();
		// Loop to Play All Questions
		for(intCount = 0; intCount < intQuestions; intCount++){
			//con.clear();
			// Display Updated HUD
			con.println((strName+"                                 ").substring(0, 33)+(strQuizName+"                                 ").substring(0, 33) +dblPercent+"%");
			// Display Question
			con.println("\n\n");
			con.println(strQuiz[intCount][0]);
			for(intColumn = 1; intColumn <= 4; intColumn++){				
				// Display Answers
				con.println(intColumn+": "+strQuiz[intCount][intColumn]);
			}
			// User Selects Answer
			con.println("\n\n");
			con.println("Enter your answer as a number from 1-4: ");
			int intResponse = con.readInt();
			System.out.println("User's Answer: "+intResponse);
			// Indicate Correct/Incorrect Answer
			con.println("Correct Answer: "+strQuiz[intCount][5]);
			System.out.println("Correct Answer: "+strQuiz[intCount][5]);
			// Check if User's Answer Matches and Add to Count
			if((strQuiz[intCount][intResponse]).equals(strQuiz[intCount][5])){
				con.println("Your answer is correct");
				dblCorrect = dblCorrect + 1;
			}else{
				con.println("Your answer is incorrect");
			}
			System.out.println("Number of correct questions: "+dblCorrect);
			// HUD Score Calculation
			dblPercent = (dblCorrect/intQuestions) * 100;
			System.out.println("% of correct questions: "+dblPercent);
			// Clear
			con.print("Press any key to continue");
			chrCont = con.getChar();
			con.clear();
		}
		// Display Final Score
		con.println("Final Score: "+dblPercent);
		con.print("Press any key to continue");
		chrCont = con.getChar();
		// Add Score to High Score Page
		TextOutputFile txtScore = new TextOutputFile("highscores.txt", true);
		txtScore.println(strName);
		txtScore.println(strChoice);
		txtScore.println(dblPercent);
		txtScore.close();
	}
	
	
	
	// High Score
	public static void loadScores(Console con){
		con.print("High score page");
		// Variables - Load Array
		int intEntries = 0;
		int intCount;
		int intColumn;
		String strRead;
		// Variables - Sort
		double dblBelow;
		double dblCurrent;
		int intCount2;
		String strTemp;
		// Open Text File
		TextInputFile txtScores = new TextInputFile("highscores.txt");
		// Count Entries
		while(txtScores.eof() == false){
			for(intCount = 0; intCount < 3; intCount++){
				strRead = txtScores.readLine();
			}
			intEntries = intEntries + 1;
			System.out.println("Counted entries: "+intEntries);
		}
		System.out.println("Final count: "+intEntries);
		txtScores.close();
		// Load Unsorted Scores into Array 
		txtScores = new TextInputFile("highscores.txt");
		String strScores[][] = new String[intEntries][3];
		for(intCount = 0; intCount < intEntries; intCount++){
			for(intColumn = 0; intColumn < 3; intColumn++){
				strScores[intCount][intColumn] = txtScores.readLine();
				System.out.println("strScores["+intCount+"]["+intColumn+"] = "+strScores[intCount][intColumn]);
			}
		}
		// Sort Scores
		for(intCount2 = 0; intCount2 < intEntries - 1; intCount2++){
			for(intCount = 0; intCount < intEntries - intCount2 - 1; intCount++){
				dblBelow = Double.parseDouble(strScores[intCount + 1][2]);
				dblCurrent = Double.parseDouble(strScores[intCount + 1][2]);
			/*	if(intBelow > intCurrent){
					// Name
					strTemp = strScores[intCount + 1][0];
					strScores[intCount + 1][0] = strScores[intCount][0];
					strScores[intCount][0] = strTemp;
					// Quiz
					strTemp = strScores[intCount + 1][1];
					strScores[intCount + 1][1] = strScores[intCount][1];
					strScores[intCount][1] = strTemp;
					// Scores
					strTemp = strScores[intCount + 1][2];
					strScores[intCount + 1][2] = strScores[intCount][2];
					strScores[intCount][2] = strTemp;
				} */
			}
		}
		// Display Scores on Screen
		for(intCount = 0; intCount < intEntries; intCount++){
			for(intColumn = 0; intColumn < 3; intColumn++){
				strScores[intCount][intColumn] = txtScores.readLine();
				System.out.println("strScores["+intCount+"]["+intColumn+"] = "+strScores[intCount][intColumn]);
			}
		}
	}
	
	// Create a Quiz
	public static void create(Console con){
		con.print("Create quiz");
	}
	
	// Help
	public static void help(Console con){
		con.print("Help");
	}
}

