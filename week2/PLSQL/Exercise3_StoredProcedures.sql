
Scenario 1
Monthly Interest


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest applied successfully.');
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

SELECT AccountID,
       AccountType,
       Balance
FROM Accounts;

Scenario 2
Employee Bonus


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus IN NUMBER
)
AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus / 100)
    WHERE Department = p_department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee bonus updated successfully.');
END;
/

BEGIN
    UpdateEmployeeBonus('HR',10);
END;
/

SELECT EmployeeID,
       Name,
       Department,
       Salary
FROM Employees;

Scenario 3
Transfer Funds


CREATE OR REPLACE PROCEDURE TransferFunds(
    p_fromAccount NUMBER,
    p_toAccount NUMBER,
    p_amount NUMBER
)
AS
    v_balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_fromAccount;

    IF v_balance >= p_amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_fromAccount;

        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_toAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance.');

    END IF;

END;
/

BEGIN
    TransferFunds(2,1,500);
END;
/

SELECT AccountID,
       Balance
FROM Accounts;