package com.example.myapplication


/**
 * 1. Team - in-person payment
 * PoS - Point of Sale
 * Devices - Tap to pay, swipe, insert, QR etc
 * PoS App - An Entire app which maintains inventory, billing order, payment, tracking etc
 * Adyen Helps only in Payment
 *
 * Terminals - PoS machines for Payment
 *
 * In-Person Payment Products
 *
 *  1. Integrated Terminals - Which means the terminal gets the payment request by automation from PoS App/System (which manage every thing of order, inventory)
 *      a. Local Integration - PoS System -> Terminal -> Adyen Backend (Payment request)
 *      b. Cloud Integration - PoS System -> Adyen Backend-> Terminal (Payment request)
 *
 *  2. Standalone Terminals - Enter the amount manually and make the transaction - no integrations
 *
 *  3. Mobile Device Integrations
 *      a. Tap to Pay in iPhone in POS App - Terminal Api and iOS SDK in POS app
 *      b. Tap to Pay in Android in POS App - Terminal Api and Android SDK in POS app
 *      c. Card Reader iOS (Separate hardware device connect to mobile using bluetooth) - Terminal Api -> iOS SDK -> Card Reader in POS app
 *      d. Card Reader Android (Separate hardware device connect to mobile using bluetooth) - Terminal Api -> iOS Android -> Card Reader in POS app
 *      e. Adyen Android Payment app - POS App to Adyen app through deeplinks, intents
 *
 *      f. Separate Android devices designed by Adyen which works as terminal - has all card reader features
 *
 *  4. Plugins
 *
 * Questions -
 * 1. Which of the above 4 has high number of clients.
 * 2. Will the role which i am giving, involves in all above 4 products or specific product
 * 3. Not a question but NYC1 card reader looks cute
 *
 *
 * 2.Adyen Formula
 *  1. We build to benefit all customers (not just one)
 *  2. We make good decisions and consider the long-term benefits for our customers, Adyen and the world at large
 *  3. We launch fast and iterate
 *  4. Winning is more important than ego; we work as a team - across cultures and time zones
 *  5. We don’t hide behind email, instead we pick up the phone
 *  6. We talk straight without being rude
 *  7. We seek out different perspectives to sharpen our ideas
 *  8. We create our own path to grow toward our full potential
 *
 *  1. Build for all
 *  in OYO, build customer app that supports all countries - locale, currency, branding widgets,
 *  different types of stays - hotels/ home stays/ holiday homes, cottages - diff use-cases 1 night vs long stays
 *
 *  (Specific ex - refactored subscription flow to internationalization which was specific to India)
 *
 *  in UC, building Partner App for all partners - in all states locale - Generic for all partners - Salon, Electrician, Painter, Cleaning
 *  and operational in 5 countries with single code base
 *
 *  2. good decisions, long-term
 *  I am interested in Adyen as the way you are taking decisions to implement new tech stack like
 *  kotlin into your codebase which is relative newer (Which you have mentioned in job description).
 *  Kotlin Multiplatform is still evolving but a Large company took decision to
 *  implement from leadership team (not a PoC on sample product).
 *  This shows the decision making are good/ and solution's for long term
 *
 *  In code, use interfaces, make extendable
 *
 *  3. launch fast and iterate
 *  In UC, we have weekly releases. Maintain release cycles in Play/App consoles, crash monitoring, performance monitoring - iterate
 *
 *  4. Winning is imp than ego - work as team across cultures and time zones
 *  Ex - Tech tasks. Crashes, performance - optimize as a team regardless who wrote and when it was written
 *  In OYO, worked as a team to launch major products like design 2.0
 *  In UC, worked as a team to launch react native update
 *
 *  5. Pick up phone
 *  Did work from home for couple of years in starting of my career at OYO. Being at career start,
 *  had so doubts regarding setup, code bases, team etc. Used to contact the team mate (buddy) to clear.
 *  Even for the work, since wfh, phone communication was direct, fast, best
 *  Call them
 *
 *  6. Talk straight without being rude
 *  Communicate the direct issue. Anger is not my cup of tea
 *
 *  7. Different people/ Different perspectives
 *  I am more interested in Adyen because the diversity of the people that are in. I did a research like
 *  searched linkedin to see who could be my future colleagues. Like Android/kotlin devs in Adyen.
 *  I was amazed to see people from different regions - hence they have diff perspectives
 *
 *  I worked in the teams when the people are from different parts of India where the culture, language is different
 *  No other person is from same state of mine. no one could speak my native language
 *
 *  8. Create our own path to grow towards our full potential
 *  I started my career at the times of Covid doing wfh. It took some time to understand the
 *  corporate functioning, the tech stack and where I stand and whats my role.
 *  I listed my goals and my path to become senior dev with quality learning
 *  Within 6 months, I became an important resource and go to person in my team
 *
 */
class Adyen {

}