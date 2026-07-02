
Scenario 1
Apply 1% discount for customers above 60 years


BEGIN
    FOR cust IN (
        SELECT CustomerID
        FROM Customers
        WHERE MONTHS_BETWEEN(SYSDATE, DOB)/12 > 60
    )
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE CustomerID = cust.CustomerID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated successfully.');
END;
/

SELECT CustomerID, InterestRate
FROM Loans;


Scenario 2
Promote customers to VIP


BEGIN
    FOR cust IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )
    LOOP
        UPDATE Customers
        SET IsVIP='TRUE'
        WHERE CustomerID=cust.CustomerID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP customers updated successfully.');
END;
/

SELECT CustomerID,
       Name,
       Balance,
       IsVIP
FROM Customers;


Scenario 3
Loan reminder


BEGIN
    FOR loan IN (
        SELECT LoanID,
               CustomerID,
               EndDate
        FROM Loans
        WHERE EndDate BETWEEN SYSDATE AND SYSDATE+30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan '
            || loan.LoanID
            || ' for Customer '
            || loan.CustomerID
            || ' is due on '
            || TO_CHAR(loan.EndDate,'DD-MON-YYYY')
        );
    END LOOP;
END;
/