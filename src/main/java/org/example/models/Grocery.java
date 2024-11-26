package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
     public static List<String> groceryList = new ArrayList<>();

     public static void startGrocery(){
         Scanner scanner = new Scanner(System.in);

         while (true){
             System.out.println("0 - Uygulamayı durdur");
             System.out.println("1 - Eleman ekle");
             System.out.println("2 - Eleman çıkar");

             int choice = scanner.nextInt();
             scanner.nextLine();  // Scanner'dan newline karakterini temizler

             if (choice == 0) {
                 // Uygulamayı sonlandır
                 System.out.println("Uygulama sonlandırılıyor...");
                 break;
             } else if (choice == 1) {
                 // Eleman ekleme
                 System.out.println("Eklemek istediğiniz elemanları giriniz (virgüllerle ayırın):");
                 String input = scanner.nextLine();
                 addItems(input);
             } else if (choice == 2) {
                 // Eleman çıkarma
                 System.out.println("Çıkarmak istediğiniz elemanları giriniz (virgüllerle ayırın):");
                 String input = scanner.nextLine();
                 removeItems(input);
             } else {
                 System.out.println("Geçersiz seçenek. Lütfen 0, 1 veya 2 giriniz.");
             }

             // Her işlemden sonra liste sıralanır
             printSorted();
         }

         scanner.close();
     }

    // Eleman ekleyen metod
    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim(); // Boşluklardan kurtul
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
                System.out.println(item + " listeye eklendi.");
            } else {
                System.out.println(item + " zaten listede mevcut.");
            }
        }
        Collections.sort(groceryList);
    }

    // Eleman çıkaran metod
    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim(); // Boşluklardan kurtul
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
                System.out.println(item + " listeden çıkarıldı.");
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
    }

    // Listede ürünün var olup olmadığını kontrol eden metod
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    // Listeyi sıralayıp ekrana yazdıran metod
    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Güncel alışveriş listesi (sıralı):");
        for (String item : groceryList) {
            System.out.println(item);
         }
     }
}
