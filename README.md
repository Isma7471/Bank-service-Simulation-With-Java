# Bank Service Simulation

This Java program simulates the operation of a bank with multiple service counters, handling customer arrivals, queueing, and service times. It calculates the total time taken to serve all customers and the average waiting time.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [How It Works](#how-it-works)
- [Usage](#usage)
- [Example Output](#example-output)
- [Requirements](#requirements)
- [License](#license)

## Overview
The `BankServiceSimulation2` program models a bank with multiple service counters and a customer arrival system. The program simulates customer arrivals at the bank, assigns them to counters based on queue length, and tracks their waiting time and service completion.

## Features
- Customizable number of service counters
- Configurable customer arrival rate
- Calculates total time to serve all customers
- Calculates the average waiting time for all customers
- Displays the number of customers served by each counter

## How It Works
1. **Input Parameters**: The user specifies:
   - Number of service counters.
   - Total number of customers.
   - Service time for each customer.
   - Number of customers arriving per unit time.

2. **Simulation Flow**:
   - Customers arrive and are added to the shortest queue.
   - Counters serve customers based on a specified service time.
   - Waiting time is calculated for each customer.
   - Total service time and average waiting time are calculated once all customers are served.

3. **Output**:
   - The program outputs the total time to serve all customers.
   - It shows the number of customers each counter served and the average waiting time for all customers.

## Usage
1. Compile the program:
   ```bash
   javac BankServiceSimulation2.java
   ```
2. Run the program:
   ```bash
   java BankServiceSimulation2
   ```
3. Follow the prompts to enter:
   - Number of service counters
   - Number of customers
   - Service time per customer
   - Customer arrival rate

## Example Output
```
Enter number of service counters: 2
Enter number of customers: 10
Enter time each customer will take at the counter: 3
Enter number of customers coming to the bank per unit of time: 1

Total time taken to serve all customers: 15
Number of customers served by Counter#1: 5
Number of customers served by Counter#2: 5
Average waiting time: 2.5
```

## Requirements
- Java Development Kit (JDK) 8 or higher

## License
This project is licensed under the MIT License.