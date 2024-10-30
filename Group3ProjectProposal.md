Xander Drolet, Liv Anderson, Benjamin Cobb  
10/28/2024  
COS225 11:00 AM  
**Group 3 Project Proposal: Pokemon Classification**

Our team plans to implement the Classification NLP problem for pokemon
classification. We will be using a dataset of over 1,000 Pokemon descriptions we found
through the Hugging Face dataset website given to us through GitHub1 which is just
about every Pokemon. This dataset has a name, type, and description for each
pokemon. With so many Pokemon a program that helps categorize and label pokemon
based on descriptions could be really helpful. Also, it just seemed like a fun domain to
focus on for this project.

The primary objective of our application is to take a user inputted pokedex
description of a Pokemon and the program should be able to accurately figure out the
type and other classification details of the pokemon such as type weaknesses and a
guess of what pokemon it is.

The program will include a user interface where the user can input pokedex
descriptions and then view the classification info. A Naive Bayes Classifier will use a
feature extractor to take the input and parse the input through an NLP processor to
“clean” the text into words then use the bag of words model format that can be used in
the Naive Bayes classifier. Below is a rough draft of what our project will look like in the
form of a UML Diagram:

![UML Group 3](https://github.com/user-attachments/assets/5332b064-ef23-429c-9e77-e53ce6340fdb)


[UML Diagram Link](https://lucid.app/lucidchart/29446e58-3841-4f3f-a82d-5bdd45f5be1d/edit?viewport_loc=-851%2C-348%2C1839%2C1304%2CHWEp-vi-RSFO&invitationId=inv_131f6dbc-2f0e-4c30-ab58-050746c91bcc) 

[^1]:  https://huggingface.co/datasets/tungdop2/pokemon/viewer/default/train?p=1![UML Group 3](https://github.com/user-attachments/assets/d6502523-d913-4336-93de-f68d953cf28b)
