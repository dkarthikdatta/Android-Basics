package com.example.myapplication.machinecoding;

/**
 *
 * class diagram
 *
 * + -> public
 * - -> private
 * # -> protected
 * static -> underline
 *
 *  --------------------------=---
 * | Class Name                  |
 * |------------------------------
 * |+ tyre:Tre                   |
 * |- vehicle: Int               |
 * |-------------------------=----
 * |+ getVehicle(int id): Int    |
 * |- changeTyre(Tyre tyre): void|
 * |------------------------=-----
 *
 *
 *1. Association
 *
 * A can access B. B can access A
 * A-------B
 *
 * Unidirectional Association
 * A can call B. B can't call B
 * ex: Person can call Desktop, but Desktop cant call person
 *
 * A----->B
 *
 * 1. A Multiplicity
 *
 * How many ?
 * * -> many
 *
 * Person_(2)______(1)_Room
 *
 * Person_(1..4)_____________(1)_Cab
 *
 * Person_(1)______________(*)_Vehicle
 *
 * 1. B Role/uses
 *
 * Guests_____eats______>Food
 *
 * has-an relation (Aggregation and Composition)
 *
 * 2. Aggregation
 * A <>--------B
 * A has instance of B
 * B can exists without A
 *
 * Ex:
 * Person<>-----House
 * House can exist without Person
 *
 * Desktop<>----Monitor
 * Monitor can exist without desktop
 *
 *
 * 3. Composition
 * A <#>-------B
 * A has instance of B
 * B cant exists without A
 *
 * Ex:
 * Body<#>---------Eye
 *
 * eye cant exist without body
 * eye is part of body.
 * if body destroys, eye destroys
 *
 *
 *4. Inheritance (is-a relation)
 *
 * A-------|>B
 * A is a B
 * interface - mention in dotted line
 *
 */