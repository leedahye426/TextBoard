package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

class App {
    void run() {
        System.out.println("== 명언 앱 ==");

        ArrayList<Quotation> quotations = new ArrayList<>();
        int lastQuotationId = 0;

        while (true) {
            System.out.print("명언) ");

            Scanner sc = new Scanner(System.in);
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = sc.nextLine();

                System.out.print("작가 : ");
                String author = sc.nextLine();

                lastQuotationId++; // 명언 번호 증가
                int id = lastQuotationId;

                Quotation quotation = new Quotation(id, content, author); // 명언 객체 생성

                quotations.add(quotation); // 명언 list에 추가

                System.out.printf("%d번 명언이 등록되었습니다.\n",  lastQuotationId);
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("------------------");

                for(Quotation quotation : quotations) {
                    System.out.printf("%d / %s / %s\n", quotation.id, quotation.author, quotation.content);
                }
            } else if (cmd.startsWith("삭제?id=")) {
                int deleteId = Integer.parseInt(cmd.substring(6)); // cmd에서
                for(Quotation quotation : quotations) {
                    if(quotation.id == deleteId) {
                        quotations.remove(quotation);
                    }
                }
                System.out.printf("%d번 명언이 삭제되었습니다.\n", deleteId);
            }

        }
    }
}