# 08

## პოლიმორფიზმი

არითმეტიკული გამოსახულება წარმოადგინეთ ხის სახით და შექმენით მონაცემთა სტრუქტურა ხის წვეროების შესანახად.
მაგალითი: 1 + 2 \* 3

თითოეულ კვანძს ჰქონდეს მინიმუმ ორი მეთოდი:

- `double evaluate()` -­ დააბრუნოს გამოთვლილი მნიშვნელობა კვანძისთვის
- `String toString()` -­ დააბრუნოს სტრიქონის სახით ჩაწერილი გამოსახულება გამოთვლის გარეშე, ფრჩხილებიც დასვას. სტრიქონი უნდა მოიცავდეს კვანძის ქვეხეში არსებულ სხვა გამოსახულებებსაც, მაგალითად (1 + (2 \* 3))
