import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
  int arrivalTime;
  int waitingTime;

  Customer(int arrivalTime) {
    this.arrivalTime = arrivalTime;
    this.waitingTime = 0;
  }
}

public class BankServiceSimulation2 {
	@SuppressWarnings("unchecked")
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Getting inputs
    System.out.print("Enter number of service counters: ");
    int numCounters = scanner.nextInt();

    System.out.print("Enter number of customers: ");
    int numCustomers = scanner.nextInt();

    System.out.print("Enter time each customer will take at the counter: ");
    int serviceTime = scanner.nextInt();

    System.out.print("Enter number of customers coming to the bank per unit of time: ");
    int arrivalRate = scanner.nextInt();

    // Initializing counters and queues
    int[] counters = new int[numCounters];
    int[] customersServed = new int[numCounters];
    Queue<Customer>[] queues = new LinkedList[numCounters]; // Explicitly specify type

    for (int i = 0; i < numCounters; i++) {
      queues[i] = new LinkedList<Customer>(); // Explicitly specify type
    }
    int totalWaitingTime = 0;

    int currentTime = 0;
    int customersArrived = 0;
    int customersProcessed = 0;
    int firstCustomerStartTime = -1;
    int lastCustomerEndTime = 0;

    while (customersProcessed < numCustomers) {
      // New customers arrive
      for (int i = 0; i < arrivalRate && customersArrived < numCustomers; i++) {
        Customer newCustomer = new Customer(currentTime);
        int shortestQueueIndex = 0;
        for (int j = 1; j < numCounters; j++) {
          if (queues[j].size() < queues[shortestQueueIndex].size()) {
            shortestQueueIndex = j;
          }
        }
        queues[shortestQueueIndex].add(newCustomer);
        customersArrived++;
      }

      // Check each counter to see if it's free and assign a new customer if available
      for (int i = 0; i < numCounters; i++) {
        if (counters[i] == 0 && !queues[i].isEmpty()) {
          Customer customer = queues[i].poll();
          customer.waitingTime = currentTime - customer.arrivalTime;
          totalWaitingTime += customer.waitingTime;
          counters[i] = serviceTime;
          customersServed[i]++;
          customersProcessed++;

          // Mark the start time of the first customer
          if (firstCustomerStartTime == -1) {
            firstCustomerStartTime = currentTime;
          }
          // Update the end time of the last customer
          lastCustomerEndTime = currentTime + serviceTime;
        }
      }

      // Decrease remaining service time for each counter
      for (int i = 0; i < numCounters; i++) {
        if (counters[i] > 0) {
          counters[i]--;
        }
      }

      // Increment current time
      currentTime++;
    }

    // Output results
    System.out.println("Total time taken to serve all customers: " + (lastCustomerEndTime - firstCustomerStartTime));
    for (int i = 0; i < numCounters; i++) {
      System.out.println("Number of customers served by Counter#" + (i + 1) + ": " + customersServed[i]);
    }
    double averageWaitingTime = (double) totalWaitingTime / numCustomers;
    System.out.println("Average waiting time: " + averageWaitingTime);

    scanner.close();
  }
}
