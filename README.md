
Втора лабораториска вежба по Софтверско инженерство

---

Илија Ристов, бр. на индекс 233163

---

Control Flow Graph
Фотографии од control flow graph-от

![Slika1](https://github.com/user-attachments/assets/015be6fe-ce5c-420b-a61f-3bb8efdcea32)
![Slika2](https://github.com/user-attachments/assets/24731cca-cfe8-44f9-963a-05b2e6e9f202)


---

Цикломатска комплексност
Цикломатската комплексност на овој код е 7, добиена преку формулата:
- Број на if()-ови = 6
- Комплексност = 6 + 1 = 7

Тест случаи според критериумот Every Statement
1. `allItems == null` ➝ фрла RuntimeException
2. `item.getName() == null` ➝ фрла RuntimeException
3. `item.getPrice() > 300` ➝ активира -30
4. `item.getDiscount() > 0` ➝ пресметка со попуст
5. `валидна картичка` ➝ враќа резултат
6. `картичка со невалидни знаци` ➝ RuntimeException

Тест случаи според критериумот Multiple Condition
1. T || X || X ➝ TRUE
2. F || T || X ➝ TRUE
3. F || F || T ➝ TRUE
4. F || F || F ➝ FALSE

Објаснување на unit тестовите
Тестовите се напишани со JUnit. Првиот метод ги покрива сите линии, вториот ги проверува сите логички гранки за комбинирани услови.
