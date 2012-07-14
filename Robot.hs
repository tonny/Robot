module Main where
import Data.List

main::IO()
main = mapM_ putStrLn . bestSolution . lines =<< getContents

bestSolution :: [[Char]] -> [String]
bestSolution mapa = let (x,y) = getXY 0 0 mapa
		    in ((show x) ++" "++ (show y)):[]

getXY :: Int -> Int -> [[Char]] -> (Int,Int)
getXY posx posy [] = (posx,posy)
getXY posx posy (x:xs) = case elemIndex 'R' x of
		          (Just r) -> getXY r posy []
                          _        -> getXY posx (posy+1) xs 
