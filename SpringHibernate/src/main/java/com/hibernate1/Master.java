package com.hibernate1;
import com.hibernate1.config.HibernateConfig;
import com.hibernate1.model.BankBranch;
import com.hibernate1.model.User;
import com.hibernate1.service.BankService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class Master {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        BankService bankService = context.getBean(BankService.class);

        BankBranch bankBranch = new BankBranch("gggggg");

        bankBranch.addUsers(new User("gagan", "123"));
        bankBranch.addUsers(new User("dsfgfd", "1222"));
        bankBranch.addUsers(new User("fffffffff", "1222"));
        bankService.saveBranchDetails(bankBranch);
        context.close();
    }
}


/*



        /*bankService.getAllPresentBranches();
        System.out.println("Please select one branch");
        int selectedBranchCode=sc.nextInt();

        BankBranch getBankBranch=bankService.findBranchById(selectedBranchCode);
        System.out.println("BANK BRANCH SELCTED DETAILS" + getBankBranch.getId());*/




        //String accountNumber=selectedBranchCode+"";
        /*User user1=new User("ppppppppppppppppppppp", accountNumber);
        User user2=new User("ooooooooooooooooooooo", accountNumber);
        bankService.updateBranchById(selectedBranchCode,user1);
        bankService.updateBranchById(selectedBranchCode,user2);

        bankService.saveUserDetails(user1);
        bankService.saveUserDetails(user2);*/

      //  getBankBranch.addUsers(new User("ooooooooooooooooooooo", accountNumber));
        //bankService.saveBranchDetails(getBankBranch);

        // add some reviews
        //bankBranch.addUsers(new User("bbbbbbb", selectedBranchCode));
        //bankBranch.addUsers(new User("xxxxxxx", selectedBranchCode));


        // save the course ... and leverage the cascade all :-)
        /*System.out.println("*********************************************************************");
        System.out.println("Saving the Bank Branch");
        System.out.println("Bank Branch " + bankBranch);
        System.out.println("Users" + bankBranch.getUserList());*/
