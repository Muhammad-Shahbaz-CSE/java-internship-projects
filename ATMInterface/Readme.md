# ATM Interface — Project 3 (DecodeLabs Java Training)

Java console application jo OOP principles use karke ek basic ATM system simulate karta hai.

## Features

- Balance check
- Deposit money
- Withdraw money (insufficient balance par reject hota hai)
- Invalid input se crash nahi hota (robust validation)

## Project Structure

| Class | Responsibility |
|---|---|
| `BankAccount` | Data + business logic. Balance `private` hai (encapsulation). Deposit/withdraw ke rules enforce karta hai. |
| `ATM` | User interface. Menu dikhata hai, Scanner se input leta hai, messages print karta hai. |
| `ATMInterface` | Entry point — `main()` method, dono classes ko connect karta hai. |

## How to Run

```bash
javac ATMInterface.java
java ATMInterface
```

## Sample Menu

```
===== ATM MENU =====
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
Enter your choice:
```

## Key OOP Concepts Used

- **Encapsulation**: `balance` aur `accountNumber` private hain, sirf public methods (`deposit`, `withdraw`, `checkBalance`) ke through access hote hain.
- **Separation of Concerns**: `BankAccount` ko console/Scanner ke baare mein kuch nahi pata — sirf logic handle karta hai. `ATM` sirf presentation layer hai.
- **Input Validation**: `hasNextInt()` / `hasNextDouble()` se input type check hota hai crash hone se pehle.

## Default Account

- Account Number: `ACC001`
- Starting Balance: `1000.0`

(Ye values `ATMInterface.java` ke `main()` method mein change ki ja sakti hain.)

## Possible Extensions (Project ke conclusion slide se)

- Transaction history feature
- PIN-based login
- Multiple accounts support
