package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

class App {
    Scanner sc;
    ArrayList<Quotation> quotations;
    int lastQuotationId;

    App() {
        sc = new Scanner(System.in);
        quotations = new ArrayList<>();
        lastQuotationId = 0;
    }
    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명언) ");

            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제?id=")) {
                actionRemove(cmd);
            }
        }
    }
    void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        lastQuotationId++; // 명언 번호 증가
        int id = lastQuotationId;

        Quotation quotation = new Quotation(id, content, author); // 명언 객체 생성

        quotations.add(quotation); // 명언 list에 추가

        System.out.printf("%d번 명언이 등록되었습니다.\n",  lastQuotationId);
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");

        for(Quotation quotation : quotations) {
            System.out.printf("%d / %s / %s\n", quotation.id, quotation.author, quotation.content);
        }
    }

    void actionRemove(String cmd) {
        int id = Integer.parseInt(cmd.replace("삭제?id=",""));
        boolean flag = false;

        for(Quotation quotation : quotations) {
            if(quotation.id == id) {
                quotations.remove(quotation);
                flag = true;
                System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
            }
        }

        if(!flag) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
        }


    }
}