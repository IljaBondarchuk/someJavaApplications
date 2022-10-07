package bankaccountapp;

public interface IBaseRate {
    default double getRate(){
        return 2.5;
    };

}
