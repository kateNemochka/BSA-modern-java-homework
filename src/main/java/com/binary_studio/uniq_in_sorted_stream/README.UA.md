# Re: Re: Re: Re: Re: Re: Re: Job opportunity at Corporation inc.

Привіт, майбутній співробітник! Прийміть наші вітання: ви пройшли всі етапи інтерв'ю і вам залишилося
зробити останній крок на шляху до роботи вашої мрії. Для оцінки ваших практичних навичок наш IT
департамент підібрав для вас нескладне завдання з беклога одного з наших продуктів.
Результат виконання завдання буде оцінений одним з провідних програмістів, і в разі якщо ви нам підходите,
ми зв'яжемося з вами протягом робочого тижня з моменту відправки виконаного завдання. Тікет з таск-трекера додається до
даного листа.

Всього доброго, HR відділ Corporation inc.

# Ticket * IT-DBIS-eWRvYm9uIHRzdXJ0Cg == *
## Патч для дублікатів інкрементальних ідентефікатора

**Опис:** Баг з дублюванням записів інкрементальних ідентифікаторів був виправлений
відповідно з тікетом *[REDACTED]*, проте через це в базах з частою записом утворилося безліч сміттєвих
записів, які не використовуються. В рамках наступного патча планується створення утиліти, здатної видалити дублікати
рядків. У зв'язку з особливостями бази даних, було прийнято рішення відфільтрувати існуючі записи за ідентифікатором
і скопіювати унікальні записи в нове місце.
**Результати інветігейшена:** У кодовій базі існують всі необхідні інструменти, крім функції здатної
знайти унікальні записи. При її створенні варто врахувати два фактори:
- *Ітератор обходить записи в порядку створення, тобто записи будуть відсортовані
по зростанню приватного ключа*
- *У базі даних може міститися величезна кількість рядків, тому вивантажити їх всі в пам'ять не є можливим*


**Примітки для виконавця**: Наш ітератор реалізує *StreamAPI*, так що можеш використовувати всі проміжні операції стрімів.
Однак використання термінальних операцій, таких як reduce, collect або ітерації за допомогою foreach, -
неприпустимі. тому на великих базах даних це викличе Out Of Memory Exception. Також плюсом буде, якщо зможеш зробити це все за О (1)
по пам'яті, але це не обов'язкова вимога. Успіхів!