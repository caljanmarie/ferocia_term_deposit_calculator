># Ferocia Code Exercise - Term Deposit Calculator
A simple CLI-based term deposit calculator written in Java using Maven.

## Features
- Accepts user inputs for:
    - Initial deposit amount
    - Interest rate
    - Investment term (in years)
    - Interest payment frequency (monthly, quarterly, annually, maturity)
- Calculates the final balance with compound interest
- Validates input and handles edge cases gracefully
- Clean, modular code with tests

## Constraints and Assumptions based on the Bendigo Bank online term deposit calculator:
1. Initial Deposit Amount
- Minimum: $1,000.00
- Maximum: $1,500,000.00
- Input must be a valid numeric value greater than or equal to the minimum and less than or equal to the maximum.

2. Annual Interest Rate
- Maximum: 15%
- Zero or negative values are not allowed.
- Input must be a valid numeric percentage greater than 0 and less than or equal to 15.

3. Investment Term
- Only whole number values from 1 to 5 (inclusive) are allowed.
- Term is expressed in years.

4. Interest Payment Frequency
- Accepted values:
  - MO or mo → Monthly
  - Q or q → Quarterly
  - A or a → Annually
  - MA or ma → At Maturity
- Invalid entries will be rejected with an appropriate error message.

5. Final Balance Output
- The final computed balance is rounded to the nearest whole number.
- Output is formatted in Australian currency (AUD) using standard money formatting.

## Prerequisites
- IntelliJ IDE
- Java 17+
- Maven 3.8+
- Git (if cloning)

## How to install and run the app (Maven or Manually generating the jar)
- Using Maven
1. Clone the repository
2. Install Maven if not yet installed (https://www.baeldung.com/install-maven-on-windows-linux-mac)
   - mvn -v (check if maven is installed)
3. Build with Maven 
    - mvn clean install (This will generate a JAR file under the target/ directory.)
3. Run the app
    - Run via Maven: mvn exec:java -Dexec.mainClass="com.ferocia.termdeposit.TermDepositCalculator"
    - Run the JAR manually: java -jar target/Ferocia_TermDepositCalculator-1.0-SNAPSHOT.jar
---
- Build Runnable JAR in IntelliJ
1. Clone the repository
2. Go to File → Project Structure > Artifacts
   - Click the + button → JAR → From modules with dependencies
   - Choose main class: TermDepositCalculator
   - Select the module (your project)
   - Tick the checkbox: Include in project build
   - Click OK
3. Build the JAR
   - Go to Build → Build Artifacts...
   - Select Ferocia_TermDepositCalculator:jar
   - Click Build
4. Run the JAR
   java -jar out/artifacts/Ferocia_TermDepositCalculator_jar/Ferocia_TermDepositCalculator.jar
    
## How to run test
- Using Maven 
  - mvn clean test
---
- Manually running test in IntelliJ
1. Right-click package folder src > test > java > com.ferocia.termdeposit.service
2. Select play/run icon (▶) Run "Tests in 'com.ferocia.termdeposit.service'" 