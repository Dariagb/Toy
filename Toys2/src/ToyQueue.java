import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

class ToyQueue {

    private PriorityQueue<Toys> queue;

    public ToyQueue(String toy1, String toy2, String toy3) {
        queue = new PriorityQueue<>((t1, t2) -> t2.getWeight() - t1.getWeight());

        addToyFromString(toy1);
        addToyFromString(toy2);
        addToyFromString(toy3);
        System.out.println(queue.peek());
    }


private void addToyFromString(String toyString) {
    String[] toyFields = toyString.split(" ");
    int id = Integer.parseInt(toyFields[0]);
    String name = toyFields[1];
    int weight = Integer.parseInt(toyFields[2]);
    Toys toy = new Toys(id, name, weight);
    queue.add(toy);
}
    public void writeResultsToFile() throws IOException {
    try (FileWriter writer = new FileWriter("output.txt"))
    {
        for (int i = 0; i < 10; i++) {
            Toys toy = getRandomToy();
            if (toy != null) {
                writer.write(Integer.toString(toy.getId()) + " " + toy.getName() + "\n");
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private Toys getRandomToy() {
        int random = (int) (Math.random() * 10);
        if (random < 2) {
            return queue.poll();
        } else if (random >= 2 && random < 4) {
            queue.add(queue.poll());
            return queue.poll();
        } else {
            return queue.peek();
        }
    }
}
