package PokerHand;

import java.util.*;

public class PokerHand {

    public enum Result { TIE, WIN, LOSS }

    private List<Card> cards;
    private HandRank handRank;

    public PokerHand(String hand) {
        cards = new ArrayList<>();
        String[] cardStrings = hand.split(" ");
        for (String cardString : cardStrings) {
            cards.add(new Card(cardString));
        }
        Collections.sort(cards, Collections.reverseOrder());
        handRank = evaluateHandRank();
    }

    public Result compareWith(PokerHand hand) {
        int comparison = handRank.compareTo(hand.handRank);
        if (comparison > 0) return Result.WIN;
        if (comparison < 0) return Result.LOSS;
        return Result.TIE;
    }

    private HandRank evaluateHandRank() {
        if (isRoyalFlush()) return new HandRank(10, getHighCards());
        if (isStraightFlush()) return new HandRank(9, getHighCards());
        if (isFourOfAKind()) return new HandRank(8, getFourOfAKindCards());
        if (isFullHouse()) return new HandRank(7, getFullHouseCards());
        if (isFlush()) return new HandRank(6, getHighCards());
        if (isStraight()) return new HandRank(5, getHighCards());
        if (isThreeOfAKind()) return new HandRank(4, getThreeOfAKindCards());
        if (isTwoPair()) return new HandRank(3, getTwoPairCards());
        if (isOnePair()) return new HandRank(2, getOnePairCards());
        return new HandRank(1, getHighCards());
    }

    private boolean isRoyalFlush() {
        return isStraightFlush() && cards.get(0).getValue() == 14;
    }

    private boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    private boolean isFourOfAKind() {
        Map<Integer, Integer> valueCount = getValueCount();
        return valueCount.containsValue(4);
    }

    private boolean isFullHouse() {
        Map<Integer, Integer> valueCount = getValueCount();
        return valueCount.containsValue(3) && valueCount.containsValue(2);
    }

    private boolean isFlush() {
        char suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (card.getSuit() != suit) return false;
        }
        return true;
    }

    private boolean isStraight() {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getValue() - cards.get(i + 1).getValue() != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isThreeOfAKind() {
        Map<Integer, Integer> valueCount = getValueCount();
        return valueCount.containsValue(3);
    }

    private boolean isTwoPair() {
        Map<Integer, Integer> valueCount = getValueCount();
        int pairCount = 0;
        for (int count : valueCount.values()) {
            if (count == 2) pairCount++;
        }
        return pairCount == 2;
    }

    private boolean isOnePair() {
        Map<Integer, Integer> valueCount = getValueCount();
        return valueCount.containsValue(2);
    }

    private Map<Integer, Integer> getValueCount() {
        Map<Integer, Integer> valueCount = new HashMap<>();
        for (Card card : cards) {
            valueCount.put(card.getValue(), valueCount.getOrDefault(card.getValue(), 0) + 1);
        }
        return valueCount;
    }

    private List<Integer> getHighCards() {
        List<Integer> highCards = new ArrayList<>();
        for (Card card : cards) {
            highCards.add(card.getValue());
        }
        return highCards;
    }

    private List<Integer> getFourOfAKindCards() {
        Map<Integer, Integer> valueCount = getValueCount();
        List<Integer> result = new ArrayList<>();
        int fourOfAKindValue = 0;
        for (Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == 4) {
                fourOfAKindValue = entry.getKey();
                break;
            }
        }
        result.add(fourOfAKindValue);
        for (Card card : cards) {
            if (card.getValue() != fourOfAKindValue) {
                result.add(card.getValue());
                break;
            }
        }
        return result;
    }

    private List<Integer> getFullHouseCards() {
        Map<Integer, Integer> valueCount = getValueCount();
        List<Integer> result = new ArrayList<>();
        int threeOfAKindValue = 0;
        int pairValue = 0;
        for (Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == 3) {
                threeOfAKindValue = entry.getKey();
            } else if (entry.getValue() == 2) {
                pairValue = entry.getKey();
            }
        }
        result.add(threeOfAKindValue);
        result.add(pairValue);
        return result;
    }

    private List<Integer> getThreeOfAKindCards() {
        Map<Integer, Integer> valueCount = getValueCount();
        List<Integer> result = new ArrayList<>();
        int threeOfAKindValue = 0;
        for (Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == 3) {
                threeOfAKindValue = entry.getKey();
                break;
            }
        }
        result.add(threeOfAKindValue);
        for (Card card : cards) {
            if (card.getValue() != threeOfAKindValue) {
                result.add(card.getValue());
            }
        }
        return result;
    }

    private List<Integer> getTwoPairCards() {
        Map<Integer, Integer> valueCount = getValueCount();
        List<Integer> result = new ArrayList<>();
        int highPairValue = 0;
        int lowPairValue = 0;
        int kickerValue = 0;
        for (Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == 2) {
                if (entry.getKey() > highPairValue) {
                    lowPairValue = highPairValue;
                    highPairValue = entry.getKey();
                } else {
                    lowPairValue = entry.getKey();
                }
            } else {
                kickerValue = entry.getKey();
            }
        }
        result.add(highPairValue);
        result.add(lowPairValue);
        result.add(kickerValue);
        return result;
    }

    private List<Integer> getOnePairCards() {
        Map<Integer, Integer> valueCount = getValueCount();
        List<Integer> result = new ArrayList<>();
        int pairValue = 0;
        for (Map.Entry<Integer, Integer> entry : valueCount.entrySet()) {
            if (entry.getValue() == 2) {
                pairValue = entry.getKey();
                break;
            }
        }
        result.add(pairValue);
        for (Card card : cards) {
            if (card.getValue() != pairValue) {
                result.add(card.getValue());
            }
        }
        return result;
    }

    // Inner class for card representation
    private class Card implements Comparable<Card> {
        private int value;
        private char suit;

        Card(String card) {
            char valueChar = card.charAt(0);
            suit = card.charAt(1);
            if (valueChar >= '2' && valueChar <= '9') {
                value = valueChar - '0';
            } else {
                switch (valueChar) {
                    case 'T': value = 10; break;
                    case 'J': value = 11; break;
                    case 'Q': value = 12; break;
                    case 'K': value = 13; break;
                    case 'A': value = 14; break;
                }
            }
        }

        int getValue() {
            return value;
        }

        char getSuit() {
            return suit;
        }

        @Override
        public int compareTo(Card o) {
            return Integer.compare(this.value, o.value);
        }
    }

    // Inner class for hand rank representation
    private class HandRank implements Comparable<HandRank> {
        private int rank;
        private List<Integer> highCards;

        HandRank(int rank, List<Integer> highCards) {
            this.rank = rank;
            this.highCards = highCards;
        }

        @Override
        public int compareTo(HandRank o) {
            if (this.rank != o.rank) {
                return Integer.compare(this.rank, o.rank);
            } else {
                for (int i = 0; i < this.highCards.size(); i++) {
                    int comparison = Integer.compare(this.highCards.get(i), o.highCards.get(i));
                    if (comparison != 0) {
                        return comparison;
                    }
                }
            }
            return 0;
        }
    }
}

