import Foundation

@objc public class WebViewWatchDog: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
