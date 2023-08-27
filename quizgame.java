import arc.*;
import java.awt.Font;
import java.awt.Color;

public class quizgame{
	public static void main(String[] args){
		
		System.out.println("testing");
		
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
		Font fntMenuButtons = con.loadFont("lemon-milk.ttf",20);
		Font fntTitle = con.loadFont("lemon-milk.ttf",100);
		
		while(dblPage > 0){
		
			// 1.1 Main Menu
			chrMenu = 'i';
			con.println("Main menu page");
			menuDisplay(con, fntTitle, fntMenuButtons);
			//dblPage = menuSelect(con);
			int intX = con.currentMouseX();
			int intY = con.currentMouseY();
			int intClick;
			dblPage = 1.1;
			while(dblPage == 1.1){
				System.out.println("Menu");
				intX = con.currentMouseX();
				intY = con.currentMouseY();
				System.out.println("x: "+intX);
				System.out.println("y: "+intY);
				// Play
				while(intX >= 300 && intX <= 980 && intY >= 340 && intY <= 400) {
					intX = con.currentMouseX();
					intY = con.currentMouseY();
					intClick = con.currentMouseButton();
					con.setDrawColor(new Color(168, 218, 230));
					con.drawRect(300,340,680,60);
					System.out.println("Play");
					System.out.println("x: "+intX);
					System.out.println("y: "+intY);
					System.out.println("Mouse: "+intClick);
					if(con.currentMouseButton() == 1){
						dblPage = 2.1;
					}
				}
				con.setDrawColor(Color.WHITE);
				con.drawRect(300,340,680,60);
				// High Scores
				while(intX >= 300 && intX <= 980 && intY >= 410 && intY <= 470) {
					intX = con.currentMouseX();
					intY = con.currentMouseY();
					intClick = con.currentMouseButton();
					con.setDrawColor(new Color(168, 218, 230));
					con.drawRect(300,410,680,60);
					System.out.println("Scores");
					System.out.println("x: "+intX);
					System.out.println("y: "+intY);
					System.out.println("Mouse: "+intClick);
					if(con.currentMouseButton() == 1){
						dblPage = 3.1;
					}
				}
				con.setDrawColor(Color.WHITE);
				con.drawRect(300,410,680,60);
				// Create Quiz
				while(intX >= 300 && intX <= 980 && intY >= 480 && intY <= 540) {
					intX = con.currentMouseX();
					intY = con.currentMouseY();
					intClick = con.currentMouseButton();
					con.setDrawColor(new Color(168, 218, 230));
					con.drawRect(300,480,680,60);
					System.out.println("Create");
					System.out.println("x: "+intX);
					System.out.println("y: "+intY);
					System.out.println("Mouse: "+intClick);
					if(con.currentMouseButton() == 1){
						dblPage = 4.1;
					}
				}
				con.setDrawColor(Color.WHITE);
				con.drawRect(300,480,680,60);
				// Help
				while(intX >= 300 && intX <= 980 && intY >= 550 && intY <= 610) {
					intX = con.currentMouseX();
					intY = con.currentMouseY();
					intClick = con.currentMouseButton();
					con.setDrawColor(new Color(168, 218, 230));
					con.drawRect(300,550,680,60);
					System.out.println("Help");
					System.out.println("x: "+intX);
					System.out.println("y: "+intY);
					System.out.println("Mouse: "+intClick);
					if(con.currentMouseButton() == 1){
						dblPage = 5.1;
					}
				}
				con.setDrawColor(Color.WHITE);
				con.drawRect(300,550,680,60);
				// Quit
				while(intX >= 300 && intX <= 980 && intY >= 620 && intY <= 680) {
					intX = con.currentMouseX();
					intY = con.currentMouseY();
					intClick = con.currentMouseButton();
					con.setDrawColor(new Color(168, 218, 230));
					con.drawRect(300,620,680,60);
					System.out.println("Quit");
					System.out.println("x: "+intX);
					System.out.println("y: "+intY);
					System.out.println("Mouse: "+intClick);
					if(con.currentMouseButton() == 1){
						dblPage = 6.1;
					}
				}
				con.setDrawColor(Color.WHITE);
				con.drawRect(300,620,680,60);
			// Play
				/*System.out.println("testing 2");
				intX = con.currentMouseX();
				intY = con.currentMouseY();
				intClick = con.currentMouseButton();
				System.out.println("x: "+intX);
				System.out.println("y: "+intY);
				System.out.println("Mouse: "+intClick);
				while(intX >= 300 && intX <= 980 && intY >= 340 && intY <= 400) {
					System.out.println("testing 4");
					intX = con.currentMouseX();
					intY = con.currentMouseY();
					intClick = con.currentMouseButton();
					con.setDrawColor(new Color(168, 218, 230));
					con.drawRect(300,340,680,60);
					System.out.println("x: "+intX);
					System.out.println("y: "+intY);
					System.out.println("Mouse: "+intClick);
					System.out.println("dblPage = "+dblPage);
					
					if(con.currentMouseButton() == 1){
						dblPage = 2.1;
					}
				}
				con.setDrawColor(Color.WHITE);
				con.drawRect(300,340,680,60);
				con.clear(); */
			
			}
			
			// 2.1 Play Quiz 
			while(dblPage == 2.1){
				con.repaint();
				con.clear();
				// Enter Name
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1280,720);
				con.repaint();
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
			
			// 3.1 High Scores
			while(dblPage == 3.1){
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1280,720);
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
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1280,720);
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
				con.setDrawColor(Color.BLACK);
				con.fillRect(0,0,1280,720);
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
	public static void menuDisplay(Console con, Font fntTitle, Font fntMenuButtons){
		System.out.println("testing 3");
		con.clear();
		//con.println("Select an option:\n(p)lay\nHigh (s)cores\n(c)reate quiz\n(h)elp\n(q)uit");
		con.setDrawFont(fntTitle);
		con.drawString("TEMPORARY NAME",100,50);
		//drawRect(int intX, int intY, int intWidth, int intHeight)
		con.setDrawColor(Color.WHITE);
		con.setDrawFont(fntMenuButtons);
		con.drawString("Quit",350,635);
		con.drawRect(300,620,680,60);
		con.drawString("Help",350,565);
		con.drawRect(300,550,680,60);
		con.drawString("Create Quiz",350,495);
		con.drawRect(300,480,680,60);
		con.drawString("High Scores",350,425);
		con.drawRect(300,410,680,60);
		con.drawString("Play",350,355);
		con.drawRect(300,340,680,60);
	}
	
	// Menu Logic
	public static void menuLogic(Console con){
		System.out.println("Menu logic method");
		int intX = con.currentMouseX();
		int intY = con.currentMouseY();
		int intClick;
		double dblPage = 1.1;
		while(dblPage == 1.1){
			// Play
			while(intX >= 300 && intX <= 980 && intY >= 340 && intY <= 400) {
				intX = con.currentMouseX();
				intY = con.currentMouseY();
				intClick = con.currentMouseButton();
				con.setDrawColor(new Color(168, 218, 230));
				con.drawRect(300,340,680,60);
				System.out.println("Play");
				System.out.println("x: "+intX);
				System.out.println("y: "+intY);
				System.out.println("Mouse: "+intClick);
				if(con.currentMouseButton() == 1){
					dblPage = 2.1;
				}
			}
			con.setDrawColor(Color.WHITE);
			con.drawRect(300,340,680,60);
			// High Scores
			while(intX >= 300 && intX <= 980 && intY >= 410 && intY <= 470) {
				intX = con.currentMouseX();
				intY = con.currentMouseY();
				intClick = con.currentMouseButton();
				con.setDrawColor(new Color(168, 218, 230));
				con.drawRect(300,410,680,60);
				System.out.println("Scores");
				System.out.println("x: "+intX);
				System.out.println("y: "+intY);
				System.out.println("Mouse: "+intClick);
				if(con.currentMouseButton() == 1){
					dblPage = 2.1;
				}
			}
			con.setDrawColor(Color.WHITE);
			con.drawRect(300,410,680,60);
			// Create Quiz
			while(intX >= 300 && intX <= 980 && intY >= 480 && intY <= 540) {
				intX = con.currentMouseX();
				intY = con.currentMouseY();
				intClick = con.currentMouseButton();
				con.setDrawColor(new Color(168, 218, 230));
				con.drawRect(300,480,680,60);
				System.out.println("Create");
				System.out.println("x: "+intX);
				System.out.println("y: "+intY);
				System.out.println("Mouse: "+intClick);
				if(con.currentMouseButton() == 1){
					dblPage = 2.1;
				}
			}
			con.setDrawColor(Color.WHITE);
			con.drawRect(300,480,680,60);
			// Help
			while(intX >= 300 && intX <= 980 && intY >= 550 && intY <= 610) {
				intX = con.currentMouseX();
				intY = con.currentMouseY();
				intClick = con.currentMouseButton();
				con.setDrawColor(new Color(168, 218, 230));
				con.drawRect(300,550,680,60);
				System.out.println("Help");
				System.out.println("x: "+intX);
				System.out.println("y: "+intY);
				System.out.println("Mouse: "+intClick);
				if(con.currentMouseButton() == 1){
					dblPage = 2.1;
				}
			}
			con.setDrawColor(Color.WHITE);
			con.drawRect(300,550,680,60);
			// Quit
			while(intX >= 300 && intX <= 980 && intY >= 620 && intY <= 680) {
				intX = con.currentMouseX();
				intY = con.currentMouseY();
				intClick = con.currentMouseButton();
				con.setDrawColor(new Color(168, 218, 230));
				con.drawRect(300,620,680,60);
				System.out.println("Quit");
				System.out.println("x: "+intX);
				System.out.println("y: "+intY);
				System.out.println("Mouse: "+intClick);
				if(con.currentMouseButton() == 1){
					dblPage = 2.1;
				}
			}
			con.setDrawColor(Color.WHITE);
			con.drawRect(300,620,680,60);
		}
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
		con.sleep(50);
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
		String strChoice;
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
		// Old Version:
		/*
		int intChoice = -1;
		while(intQCount < intChoice || intQCount > intChoice){
			con.clear();
			con.println("Quiz Options:");
			for(intCount = 0; intCount < intQCount; intCount++){
				con.println(intCount+": "+strSelect[intCount]);
			}
			intChoice = con.readInt();
		}	
		System.out.println("intChoice = "+intChoice); 
		System.out.println("strSelect[intChoice] = "+strSelect[intChoice]); */
		boolean blnTest = false;
		char chrCont;
		strChoice = "a";
		while(blnTest == false){
			con.clear();
			con.println("Quiz Options:");
			for(intCount = 0; intCount < intQCount; intCount++){
				con.println(intCount+": "+strSelect[intCount]);
			}
			con.print("Enter your choice: ");
			strChoice = con.readLine();
			blnTest = choiceCheck(0, intQCount, strChoice);
			System.out.println(blnTest);
			if(blnTest == false){
				con.print("Enter a valid choice.");
			}
			con.print("Press any key to continue");
			chrCont = con.getChar();
			con.clear();
		}
		int intChoice = Integer.parseInt(strChoice);
		return strSelect[intChoice]; 
	}
	
	// Play - Quiz Selection Verification
	public static boolean choiceCheck(int intType, int intQCount, String strInput){
		//int intQ[] = new int[intQCount];
		boolean blnValid = false;
		String strQ[] = new String[intQCount];
		int intA;
		for(intA = intType; intA < intQCount; intA++){
			strQ[intA] = Integer.toString(intA);
			System.out.println(strQ[intA]);
		}
		for(intA = intType; intA < intQCount; intA++){
			if((strQ[intA]).equals(strInput)){
				blnValid = true;
			}
		}
		return blnValid;
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
			/*int intResponse = 0;
			con.println("\n\n");
			con.println("Enter your answer as a number from 1-4: ");
			intResponse = con.readInt();
			System.out.println("User's Answer: "+intResponse); */
			
			// Check if Answer is Valid
			boolean blnTest = false;
			String strInput = "a";
			while(blnTest == false){
				// HUD and Questions
				con.clear();
				con.println((strName+"                                 ").substring(0, 33)+(strQuizName+"                                 ").substring(0, 33) +dblPercent+"%");
				con.println("\n"+strQuiz[intCount][0]);
				for(intColumn = 1; intColumn <= 4; intColumn++){				
					// Display Answers
					con.println(intColumn+": "+strQuiz[intCount][intColumn]);
				}
				// User Input
				con.print("\nEnter your response as a number from 1-4: ");
				strInput = con.readLine();
				blnTest = choiceCheck(1, 5, strInput);
				System.out.println(blnTest);
				if(blnTest == false){
					con.println("\nEnter a valid choice.");
				}
				con.println("\nPress any key to continue");
				chrCont = con.getChar();
			}
			int intResponse = Integer.parseInt(strInput);
			// Indicate Correct Answer
			con.println("\nCorrect Answer: "+strQuiz[intCount][5]);
			System.out.println("Correct Answer: "+strQuiz[intCount][5]);
			// Check if User's Answer Matches and Add to Count
			if((strQuiz[intCount][intResponse]).equals(strQuiz[intCount][5])){
				con.println("\nYour answer is correct");
				dblCorrect = dblCorrect + 1;
			}else{
				con.println("\nYour answer is incorrect");
			}
			System.out.println("Number of correct questions: "+dblCorrect);
			// HUD Score Calculation
			dblPercent = (dblCorrect/intQuestions) * 100;
			System.out.println("% of correct questions: "+dblPercent);
			// Clear
			con.print("\nPress any key to continue");
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
		con.println("High score page");
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
		System.out.println("Unsorted Scores");
		for(intCount = 0; intCount < intEntries; intCount++){
			for(intColumn = 0; intColumn < 3; intColumn++){
				strScores[intCount][intColumn] = txtScores.readLine();
				System.out.println("strScores["+intCount+"]["+intColumn+"] = "+strScores[intCount][intColumn]);
			}
		}
		// Sort Scores
		int intA;
		for(intCount2 = 0; intCount2 < intEntries - 1; intCount2++){
			for(intCount = 0; intCount < intEntries - intCount2 - 1; intCount++){
				dblBelow = Double.parseDouble(strScores[intCount + 1][2]);
				System.out.println("dblBelow: "+dblBelow);
				dblCurrent = Double.parseDouble(strScores[intCount][2]);
				System.out.println("dblCurrent: "+dblCurrent);
				if(dblBelow > dblCurrent){
					System.out.println("Sorted");
					// Name
					strTemp = strScores[intCount + 1][0];
					strScores[intCount + 1][0] = strScores[intCount][0];
					strScores[intCount][0] = strTemp;
					System.out.println();
					// Quiz
					strTemp = strScores[intCount + 1][1];
					strScores[intCount + 1][1] = strScores[intCount][1];
					strScores[intCount][1] = strTemp;
					// Scores
					strTemp = strScores[intCount + 1][2];
					strScores[intCount + 1][2] = strScores[intCount][2];
					strScores[intCount][2] = strTemp;
				}else{
					System.out.println("Already in order");
				}
			}
		}
		// Check for Sorted Entries
		System.out.println("Sorted Scores");
		for(intCount = 0; intCount < intEntries; intCount++){
			for(intColumn = 0; intColumn < 3; intColumn++){
				System.out.println("strScores["+intCount+"]["+intColumn+"] = "+strScores[intCount][intColumn]);
			}
		}
		// Display Sorted Entries to Screen
		con.println(("Name                                 ").substring(0, 33)+("Quiz Played                                 ").substring(0, 33) +("Score\n"));
		for(intCount = 0; intCount < intEntries; intCount++){
			con.println((strScores[intCount][0]+"                                 ").substring(0, 33)+(strScores[intCount][1]+"                                 ").substring(0, 33) +(int)(Double.parseDouble(strScores[intCount][2]))+"%");
		}
		con.println("");
	}
	
	// Create a Quiz
	public static void create(Console con){
		boolean blnCont = true;
		int intNum = 1;
		String strIn;
		int intA;
		char chrCont;
		// Input Quiz Name
		con.print("Enter the quiz name: ");
		String strName;
		strName = con.readLine();
		// Text File
		TextOutputFile txtNew = new TextOutputFile(strName+".txt");
		// Enter Questions and Answers
		while(blnCont == true){
			con.println("Enter question "+intNum+":");
			strIn = con.readLine();
			txtNew.println(strIn);
			for(intA = 1; intA <= 4; intA++){
				con.println("Enter answer "+intA+": ");
				strIn = con.readLine();
				txtNew.println(strIn);
			} 
			con.println("Enter the (full) correct answer: ");
			strIn = con.readLine();
			txtNew.println(strIn);
			intNum++;
			// Ask User to Continue
			con.println("Add another question?\n 'y' or 'n'");
			chrCont = con.getChar();
			if(chrCont == 'n'){
				blnCont = false;
			}else if(chrCont == 'y'){
				con.clear();
			}
		}
		txtNew.close();
		TextOutputFile txtMaster = new TextOutputFile("quizzes.txt", true);
		txtMaster.println(strName);
		txtMaster.close();
	}
	
	// Help
	public static void help(Console con){
		con.print("How to Play");
	}
}

