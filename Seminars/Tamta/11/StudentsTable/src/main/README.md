მიზანი:

* TableView-ს გამოყენების მაგალითი. მისი model-view სტრუქტურა, listener პატერნი JTable-სა და TableModel-ს შორის.
* ინტერფეისების გამოყენება ფილტრის მაგალითზე. (შემდეგზე)

გეგმა:
* ცხრილში სტუდენტების დამატება
  1. SwingView-ზე ღილაკების დამატება და ActionListener-ში კომენტარებად გეგმის დაწერა
  2. Student კლასის შექმნა
  3. TableView-ს შექმნა, მისი model-view სტრუქტურის ჩვენება.
  4. StudentStore-ის შექმნა ბაზის სახით
  5. TableModel-ის დაწერა. setStudents ფუნქციით

(შემდეგზე)
* ცხრილიდან სტუდენტების გაფილტვრა 
  1. StudentStore-ს უნდა დავუმატოთ ფილტერ ფუნქცია.
  2. შევქმნათ ცალ-ცალკე ფილტრები საერთო ინტერფეისით
  3. შევქმნათ AndFilter ამ ფილტრების გასაერთიანებლად
  4. გადავცეთ AndFilter store-ის ფილტრ ფუნქციას.
  5. დავააფდეითოთ მოდელი
 