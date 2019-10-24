package com.company;

public class Task_2 {
    private StringBuffer StringTask;

    public Task_2(StringBuffer StringTask){
    this.StringTask = StringTask;
    }
    //aaaa aaaa aaaa aaaa. aaaa aaaa aaaa aaaa. aaaa aaaa aaaa aaaa. aaaa aaaa aaaa aaaa. aaaa aaaa aaaa aaaa.


    public StringBuilder Del(){
        StringBuilder LastString = new StringBuilder(StringTask);
        for(int CountPoint = 0, LastSpace = 0, i = 0; i < LastString.length(); ++i) {

            if (LastString.charAt(i) == ' ') {
                LastSpace = i;
            }
            else if (LastString.charAt(i) == '.') {
                CountPoint++;
                if (CountPoint == 1 || CountPoint == 3) {
                    LastString.delete(LastSpace, i);
                }
                //System.out.println("найдена точка");
            }
        }
       return LastString;
    }

    public StringBuilder AddText(String Sent){
        StringBuilder LastString = new StringBuilder(StringTask);
        LastString.append(" ");
        LastString.append(Sent);
        return LastString;
    }

    public StringBuffer AddWord(String Word){
        StringBuffer LastString = new StringBuffer(StringTask);
        for(int i = 0, CountPoint = 0, CountSpace = 0; i < LastString.length(); ++i){
            if (LastString.charAt(i) == '.') CountPoint++;
            if(CountPoint == 1){
                if (LastString.charAt(i) == ' ') CountSpace++;
            }

            if(CountSpace == 2){
                LastString.insert(i, (" " + Word));
                break;
            }
        }
        return LastString;
    }
}
