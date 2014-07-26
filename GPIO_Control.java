/*
 * Ismet Said Calik
 * http://ismetsaidcalik.com/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
import java.util.Scanner;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * This example code demonstrates how to perform simple state control of a GPIO
 * pin on the Raspberry Pi.
 * 
 * @author Ismet Said Calik
 */
public class GPIO_Control {
	private static Scanner cmd;
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("GPIO Control Example ... started.");
		System.out.println("Use 1 or 0 command!");
		final GpioController gpio = GpioFactory.getInstance();
		final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(
				RaspiPin.GPIO_01, "MyLED", PinState.LOW);
		cmd = new Scanner(System.in);
		while (true) {
			if (cmd.nextInt() == 1) {
				pin.high();
			}
			if (cmd.nextInt() == 0) {
				pin.low();
			} else {
				System.out.println("Use 1 or 0 command!");

			}
			
		}
	}
}
