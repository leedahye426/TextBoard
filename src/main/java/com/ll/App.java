package com.ll;

import java.util.Scanner;

class App {
    void run() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print("명언) ");

            Scanner sc = new Scanner(System.in);
            String cmd = sc.nextLine();

            if(cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String saying = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();
            }
        }
    }
}