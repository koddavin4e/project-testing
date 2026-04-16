package project;
import java.util.*;

public class RPG {
    static class Item {
        String name;
        int heal;

        Item(String name, int heal) {
            this.name = name;
            this.heal = heal;
        }
    }
    static class Enemy {
        String name;
        int hp;

        Enemy(String name, int hp) {
            this.name = name;
            this.hp = hp;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerHP = 100;
        
        //Arraylist - Inventory
        ArrayList<Item> Inventory = new ArrayList<>();
        
        //Hashmap - база предметов
        HashMap<String, Item> itemDatabase = new HashMap<>();
        itemDatabase.put("potion", new Item("Зелье лечения", 30));
        itemDatabase.put("elixir", new Item("Эликсир", 50));

        //Hashset - достижения
        HashSet<String> achievements = new HashSet<>();

        //Linkedlist - очередь врагов
        LinkedList<Enemy> enemies = new LinkedList<>();
        enemies.add(new Enemy("Гоблин", 40));
        enemies.add(new Enemy("Скелет", 60));
        enemies.add(new Enemy("Орк", 110));
        enemies.add(new Enemy("Тень игрока", 90));
        enemies.add(new Enemy("Король скелетов", 220));

        System.out.println("Fight");

        while (!enemies.isEmpty() && playerHP > 0) {
            Enemy enemy = enemies.poll();

            System.out.println("\nВраг: " + enemy.name + "(HP: " + enemy.hp + ")");
            while (enemy.hp > 0 && playerHP > 0) {
                System.out.println("1 - Атаковать | 2 - Использовать зелье");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    enemy.hp -= 20;
                    System.out.println("Ты ударил врага! Его HP: " + enemy.hp);
                } else if (choice == 2 && !Inventory.isEmpty()) {
                    Item item = Inventory.remove(0);
                    playerHP += item.heal;
                    System.out.println("Использовано: " + item.name + ". HP: " + playerHP);
                }
                if (enemy.hp > 0) {
                    playerHP -= 10;
                    System.out.println(enemy.name + " атакует! Твоё HP: " + playerHP);
                }
            }
            if (playerHP > 0) {
                System.out.println(enemy.name + " побеждён!");

                achievements.add("Побеждён " + enemy.name);

                Inventory.add(itemDatabase.get("potion"));
                System.out.println("Получено зелье!");
            }
        }

        System.out.println("\nИгра окончена...");
        System.out.println("HP игрока: " + playerHP);
        System.out.println("Достижения:");
        for (String a : achievements) {
            System.out.println("- " + a);
        }

        scanner.close();
    }
}

//Бу23131