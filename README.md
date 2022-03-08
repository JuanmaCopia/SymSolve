Tunned korat


Tell korat to save candidates:

--class "korat.examples.binarytree.BinaryTree" --args 3 --cvWrite --printCandVects


Tell korat not to modifiy and index or a set of indexes in the candidate vector:

--class "korat.examples.binarytree.BinaryTree" --args 3 --printCandVects --fixedIndexes "6,7"


Tell korat to start from an specific index in the file of candidates:

--class "korat.examples.binarytree.BinaryTree" --args 3 --printCandVects --fixedIndexes "6" --cvStart 7


Tell korat to solve an specific candidate. Korat will write the result in a file called "result" containing the word "sat" or "unsat" (this is SAT):

--class "korat.examples.binarytree.BinaryTree" --args 3 --printCandVects --fixedIndexes "6" --cvStart 7 --solve


Tell korat to solve an specific candidate. Korat will write the result in a file called "result" containing the word "sat" or "unsat" (this is UNSAT):

--class "korat.examples.binarytree.BinaryTree" --args 3 --printCandVects --fixedIndexes "7" --cvStart 7 --solve