

// The only valid inputs are all the values of intQCount
// Can only be integers

// Method
	// Returns true or false boolean
	// Code
		// Create integer array for intQCount (all the valid values)
		// Convert intQCount to a string array
		// Check if the user input matches the values of the string array
		
import arc.*;		
		
public class roughcopy{
	
	public static void main(String[] args){
		Console con = new Console();
		boolean blnTest = false;
		String strInput;
		while(blnTest == false){
			con.print("Enter your choice: ");
			strInput = con.readLine();
			blnTest = choiceCheck(10, strInput);
			con.println(blnTest);
		}
		con.println("Done");
	}
	
	public static boolean choiceCheck(int intQCount, String strInput){
		//int intQ[] = new int[intQCount];
		boolean blnValid = false;
		String strQ[] = new String[intQCount];
		int intA;
		for(intA = 0; intA < intQCount; intA++){
			strQ[intA] = Integer.toString(intA);
			System.out.println(strQ[intA]);
		}
		for(intA = 0; intA < intQCount; intA++){
			if((strQ[intA]).equals(strInput)){
				blnValid = true;
			}
		}
		return blnValid;
	}
}
		
		

