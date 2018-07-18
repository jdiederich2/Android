package edu.cvtc.jdiederich2.learnjava;

public class HelloWorld {
    public static void main(String[] args) {
        SystemResponses systemResponse = new SystemResponses();
        System.out.println(systemResponse.getHello());
        System.out.println( systemResponse.getQuestion() );

        systemResponse.setQuestion( "My name is Jen." );
        System.out.println(systemResponse.getQuestion());

        System.out.println(systemResponse.calculateFunction( 2,3 ));

        systemResponse.setLoginName( "Jennifer", "Diederich" );
        System.out.println(systemResponse.loginName);


    }
}
