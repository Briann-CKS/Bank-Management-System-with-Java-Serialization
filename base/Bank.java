import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Bank extends Admin implements Serializable{

	public Vector<User> userS = new Vector<User>();

	//main function
	public static void main(String[] args){
		Bank acc = new Bank();
		Vector<User> v = new Vector<User>();
		for (User u : acc.userS) {
			v.add(u);
		}
		System.out.println(v);
                acc.mainMenu(v);
	}

	public Bank()
	{
		initUser();
		saveUser();
		loadUser();
	}

	public void initUser()
	{	
		userS.add(new User(12345, 22441, new Checking(2000.00f), new Saving(15000.50f), "Brian")); 
		userS.add(new User(23456, 14145, new Checking(3000.50f), new Saving(20000.40f), "Ivan"));
		userS.add(new User(34567, 23511, new Checking(4000.25f), new Saving(18000.45f), "Daniel"));
		userS.add(new User(45678, 12313, new Checking(1210.30f), new Saving(30000.25f), "Leo"));
	}

	public void saveUser() 
	{
		try{
                        FileOutputStream file=new FileOutputStream("Users.dat");
                        ObjectOutputStream out=new ObjectOutputStream(file);
                        out.writeObject(userS);
                        out.close();
                        file.close();
                        } catch(Exception e){
                                System.out.println("IOException Caught");
                        }
	}

	public void saveUserA(User u, Vector v)                 
        {
                try{
			int counter = 0;
                        FileOutputStream file=new FileOutputStream("Users.dat");
                        ObjectOutputStream out=new ObjectOutputStream(file);
                        for(int i=0; i<v.size(); i++){
                        	User usr = new User();
                        	usr = (User)v.get(i);
                        	int acc = usr.acnum();
                        	int pin = usr.pin();
				if(u.acnum() == acc){
        	                        v.set(i, u);
					break;
                	        }
			}
			out.writeObject(v);
                        out.close();
                        file.close();
		} catch(Exception e){
                        System.out.println("IOException Caught");
                }
        }


	@SuppressWarnings("unchecked")		
	public void loadUser()
	{
		try{
		FileInputStream file=new FileInputStream("Users.dat");
		ObjectInputStream in=new ObjectInputStream(file);
				
		userS = (Vector)in.readObject();
		
		in.close();
		}catch(IOException ex){
			userS = new Vector();
		}catch(ClassNotFoundException ex){
			System.out.println(ex.getMessage());
		}
	}
		

	// main menu
	public void mainMenu(Vector v){
		
		System.out.println("__________________________________________________________________\n");
		System.out.println("Enter your your Account number and Pin\n");
		System.out.println("Account No. :- ");
		Scanner input = new Scanner(System.in);
		int acnum  = input.nextInt();
		
		System.out.println("Pin No. :- ");
		int pinnum = input.nextInt();

		System.out.println("__________________________________________________________________\n");
		if(acnum == 00000){
			if(pinnum == 12345){
				this.admin_menu(v);
			}
		}
		
		for(int i=0; i<v.size(); i++){
			User usr = new User();
			usr = (User)v.get(i);
			int acc = usr.acnum();
			int pin = usr.pin();
		
			if(acc == acnum){
				if(pin == pinnum){
					this.userMenu(v, usr);
				}
			}
		}
	}

	// admin menu
	public void admin_menu(Vector v){
                int choice;
		Admin a = new Admin();
                System.out.println("\nEnter Choice \n1. Add User\n2. Delete User\n3. List User\n4. Apply Interest\n5. Exit\n");
                Scanner input = new Scanner(System.in);
                choice = input.nextInt();
		
		if (choice == 1)
		{
			System.out.println("\nEnter User Account number :");
			Scanner acn = new Scanner(System.in);
			acnum = acn.nextInt();
			System.out.println("\nEnter User name :");
			Scanner nam = new Scanner(System.in);
			name = nam.nextLine();
			System.out.println("\nEnter User pin :");
			Scanner pi = new Scanner(System.in);                                
			pin = pi.nextInt();
			System.out.println("\nEnter User Saving account balance :");
                        Scanner sa = new Scanner(System.in);
                        float savv = sa.nextFloat();
			System.out.println("\nEnter User Checking account balance :");
                        Scanner ch = new Scanner(System.in);
                        float chkk = ch.nextFloat();
			v.add(addu(acnum, name, pin, savv, chkk));
			this.admin_menu(v);
		}

		else if (choice == 2)
		{
			System.out.println("\nEnter User account number to be deleted :");
			acnum = input.nextInt();
			deleteu(acnum, v);
			this.admin_menu(v);
		}

		else if (choice == 3)
		{
			listu(v);
			this.admin_menu(v);
		}

		else if (choice == 4)
		{
			addinterest(v);
			this.admin_menu(v);
		}

		else
		{
			try{
			FileOutputStream file=new FileOutputStream("Users.dat");
			ObjectOutputStream out=new ObjectOutputStream(file);
			out.writeObject(v);
			out.close();
			file.close();
			} catch(Exception e){
				System.out.println("IOException Caught");
			}
		
			System.exit(0);
		}
	}

	// user menu
	public void userMenu(Vector v, User u){
                int acType;
                int choice;

                System.out.println("\nEnter Choice\n1. Checking\n2. Savings\n3. Exit\n");
                Scanner input = new Scanner(System.in);
                acType = input.nextInt();

		if (acType == 1)
		{
			System.out.println("\nChecking account : \n");
                        System.out.println("Enter Choice\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit\n");
                        choice = input.nextInt();
			
			if (choice == 1)
			{
				System.out.println("How much would you like to deposit?\n");
                                float dep = input.nextFloat();
                                u.chk.deposit(dep);
                                this.userMenu(v, u);
			}
			
			else if (choice == 2)
			{
				System.out.println("How much would you like to withdraw?\n");
                                int with = input.nextInt();
                                u.chk.withdraw(with);
                                this.userMenu(v, u);
			}

			else if (choice == 3)
			{
				System.out.println("Current cheking balance :- \n");
                                u.chk.getcBal();
                                this.userMenu(v, u);
			}

			else if (choice == 4)
			{
				saveUserA(u, v);
				this.mainMenu(v);
			}
		}

		if(acType == 2) 
		{
			System.out.println("\nSavings account : \n");
                        System.out.println("Enter Choice\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit\n");
                        choice = input.nextInt();
			
			if (choice == 1)
			{
				System.out.println("How much would you like to deposit?\n");
                                float dep = input.nextFloat();
                                u.sav.deposit(dep);
                                this.userMenu(v, u);
			}
	
			else if (choice == 2)
			{
				System.out.println("How much would you like to withdraw? (int)\n");
                                int with = input.nextInt();
                                u.sav.withdraw(with);
                                this.userMenu(v, u);
			}

			else if (choice == 3)
			{
				System.out.println("Current savings balance :- \n");
                                u.sav.getsBal();
                                this.userMenu(v, u);
			}

			else if (choice == 4)
			{
				saveUserA(u, v);		
				this.mainMenu(v);
			}
		}
	}
}



